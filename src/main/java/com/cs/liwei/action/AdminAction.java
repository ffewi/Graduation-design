package com.cs.liwei.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.DeptForm;
import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.Page;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.service.AdminManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "adminAction")
@Scope(value = "prototype")
public class AdminAction extends ActionSupport {
    @Resource(name = "adminManagerImpl")
    private AdminManager admin;
    private Page pageMsg;
    private List<Dept> list;
    private List<ProForm> proList;
    private List<CourseForm> courseList;
    private DeptForm deptForm;
    private ProForm proForm;
    private CourseForm courseForm;
    private Method msg;
    // 用于admin ajax 修改密码用
    private Admin ad;

    /**
     * 
     */
    private static final long serialVersionUID = -7243750676583760197L;

    // ajax 修改密码判断用户存在与否验证
    public String ajaxChangeUserPassJudge() {
        boolean result = false;
        if (ad.getAccountName().equals("admin")) {
            // System.out.println("admin : 判断");
            result = admin.isHaveUser(ad, 0);
        } else if (ad.getAccountName().equals("teacher")) {
            // System.out.println("teacher : 判断");
            result = admin.isHaveUser(ad, 1);
        } else if (ad.getAccountName().equals("student")) {
            // System.out.println("student : 判断");
            result = admin.isHaveUser(ad, 2);
        }
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(result);
        } catch (IOException e) {
            // System.out.println("json error!");
            e.printStackTrace();
        }

        return null;
    }

    // ajax修改密码
    public String ajaxChangeUserPass() {
        boolean xiugaiSuccess = false;
        if (ad.getAccountName().equals("admin")) {
            // System.out.println("admin : 修改");
            xiugaiSuccess = admin.xiugaiPass(ad, 0);
        } else if (ad.getAccountName().equals("teacher")) {
            // System.out.println("teacher : 修改");
            xiugaiSuccess = admin.xiugaiPass(ad, 1);
        } else if (ad.getAccountName().equals("student")) {
            // System.out.println("student : 修改");
            xiugaiSuccess = admin.xiugaiPass(ad, 2);
        }
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(xiugaiSuccess);
        } catch (IOException e) {
            System.out.println("json error!");
            e.printStackTrace();
        }
        return null;
    }

    public String home() {
        // System.out.println("返回主页");
        return "adminhome";
    }

    // add 请求分类
    public String add() {
        String returnMsg = "";
        switch (msg.getMethod()) {
        case Method.ADD_DEPT:
            returnMsg = "deptAdd";
            break;
        case Method.ADD_PROFESSION:
            returnMsg = "deptAdd";
            break;
        case Method.ADD_COURSE:
            // 添加跳转页面
            proList = admin.getAllProfessionNameIndex();
            returnMsg = "courseAdd";
            break;
        default:
            returnMsg = "错误页码";
            break;
        }
        return returnMsg;

    }

    // update 请求分类
    public String update() {
        String returnMsg = "";
        switch (msg.getMethod()) {
        case Method.ADD_DEPT:
            returnMsg = "deptUpdate";
            break;
        case Method.ADD_PROFESSION:
            list = admin.getAllDept();
            returnMsg = "professionUpdate";
            break;
        case Method.ADD_COURSE:
            // 修改跳转页面
            proList = admin.getAllProfessionNameIndex();
            returnMsg = "courseUpdate";
            break;

        default:
            returnMsg = "错误页码";
            break;
        }
        return returnMsg;

    }

    // 模糊查询 院系名称
    public String searchDeptByNameForLike() {
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        // 模糊查询deptName获取的表
        list = admin.queryByName(deptForm.getContent());
        return "dept";
    }

    // 模糊查询 专业名称
    public String searchProByNameForLike() {
        // 模糊查询professionName获取的表
        // System.out.println(proForm.getContent());
        proList = admin.queryByProName(proForm.getContent());
        // 为添加 添加院系 这里使用的是模态框 需要给下拉院系 加载值
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (proList == null) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        list = admin.getAllDept();
        return "proIndex";
    }

    // 模糊查询 课程名称
    public String searchCourseByNameForLike() {
        // 模糊查询courseName获取的表
        // System.out.println(courseForm.getContent());
        courseList = admin.queryByCourseName(courseForm.getContent());
        return "courseIndex";
    }

    /**
     * dept修改页面 确认修改
     * 
     * @return
     */
    public String exeUpdateDeptById() {
        list = admin.updateDeptByID(deptForm);
        if (list != null) {
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
            return "dept";
        }
        return "修改错误是返回的页面";
    }

    /**
     * profession修改页面 确认修改
     * 
     * @return
     */
    public String exeUpdatePro() {
        // System.out.println(proForm.getProfessionNo() + proForm.getProfessionName());
        // System.out.println(proForm.getSelectArr()[0]);
        proList = admin.updateProByID(proForm);
        if (proList != null) {
            // 为添加添加院系
            list = admin.getAllDept();
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
            return "proIndex";
        }
        return "修改错误是返回的页面";
    }

    // 更新course
    public String exeUpdateCourse() {
        courseList = admin.updateCourseByID(courseForm);
        if (courseList != null) {
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
            // 为添加添加院系
            proList = admin.getAllProfessionNameIndex();
            return "courseIndex";
        }
        return "修改错误是返回的页面";
    }

    // 删除dept
    public String delDeptById() {
        // System.out.println("deldledlelel");
        admin.delDeptById(deptForm.getDeptNo());
        // 刷新数据
        list = admin.getAllByPage(pageMsg.getPageNo(), 10);
        int pages = admin.getPageTotal(Method.PAGE_DETP);
        pageMsg.setPageCount(pages);
        return "dept";
    }

    // 删除profession
    public String delProById() {
        // 调用删除
        admin.delProById(proForm.getProfessionNo());
        int pages = admin.getPageTotal(Method.PAGE_PROFESSION);
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(pages);
        // 刷新数据
        proList = admin.getProByPage(pageMsg.getPageNo(), 10);
        // 为添加下拉选择 加载内容
        list = admin.getAllDept();
        return "proIndex";
    }

    // 删除course
    public String delCourseById() {
        // 调用删除
        admin.delCourseById(courseForm.getCourseNo());
        // 刷新数据
        courseList = admin.getCourseByPage(pageMsg.getPageNo(), 10);
        int pages = admin.getPageTotal(Method.PAGE_COURSE);
        pageMsg.setPageCount(pages);
        return "courseIndex";
    }

    // 添加dept
    public String addDept() {
        list = admin.addDept(deptForm.getDeptName());
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "dept";
    }

    // 添加profession
    public String addPro() {
        proList = admin.addPro(proForm);
        list = admin.getAllDept();
        return "proIndex";
    }

    // 添加course
    public String addCourse() {
        // 开始添加course数据
        courseList = admin.addCourse(courseForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "courseIndex";
    }

    /**
     * 通过dept的id明确查询
     * 
     * @return
     */
    public String findDeptById() {
        list = null;
        return "dept";
    }

    /**
     * 初始进入院系页面默认显示效果
     * 
     * @return
     */
    public String getAllDeptList() {
        list = admin.getAllByPage(pageMsg.getPageNo(), 10);
        int pages = admin.getPageTotal(Method.PAGE_DETP);
        pageMsg.setPageCount(pages);
        return "dept";
    }

    /**
     * 初始进入课程页面默认显示效果
     * 
     * @return
     */
    public String getAllCourseList() {
        courseList = admin.getCourseByPage(pageMsg.getPageNo(), 10);
        int pages = admin.getPageTotal(Method.PAGE_COURSE);
        pageMsg.setPageCount(pages);
        return "courseIndex";
    }

    /**
     * 初始进入专业页面默认显示效果
     * 
     * @return
     */
    public String getAllProList() {
        proList = admin.getProByPage(pageMsg.getPageNo(), 10);
        int pages = admin.getPageTotal(Method.PAGE_PROFESSION);
        pageMsg.setPageCount(pages);
        // 为添加的dialog 加载数据
        // System.out.println(pages);
        list = admin.getAllDept();
        return "proIndex";
    }

    /**
     * @return the list
     */
    public List<Dept> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Dept> list) {
        this.list = list;
    }

    /**
     * @return the deptForm
     */
    public DeptForm getDeptForm() {
        return deptForm;
    }

    /**
     * @param deptForm the deptForm to set
     */
    public void setDeptForm(DeptForm deptForm) {
        this.deptForm = deptForm;
    }

    /**
     * @return the msg
     */
    public Method getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(Method msg) {
        this.msg = msg;
    }

    /**
     * @return the proForm
     */
    public ProForm getProForm() {
        return proForm;
    }

    /**
     * @param proForm the proForm to set
     */
    public void setProForm(ProForm proForm) {
        this.proForm = proForm;
    }

    /**
     * @return the proList
     */
    public List<ProForm> getProList() {
        return proList;
    }

    /**
     * @param proList the proList to set
     */
    public void setProList(List<ProForm> proList) {
        this.proList = proList;
    }

    public List<CourseForm> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseForm> courseList) {
        this.courseList = courseList;
    }

    /**
     * @return the courseForm
     */
    public CourseForm getCourseForm() {
        return courseForm;
    }

    /**
     * @param courseForm the courseForm to set
     */
    public void setCourseForm(CourseForm courseForm) {
        this.courseForm = courseForm;
    }

    public Page getPageMsg() {
        return pageMsg;
    }

    public void setPageMsg(Page pageMsg) {
        this.pageMsg = pageMsg;
    }

    public Admin getAd() {
        return ad;
    }

    public void setAd(Admin ad) {
        this.ad = ad;
    }

}
