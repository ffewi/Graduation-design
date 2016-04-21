package com.cs.liwei.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.DeptForm;
import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.service.AdminManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "adminAction")
@Scope(value = "prototype")
public class AdminAction extends ActionSupport {
    @Resource(name = "adminManagerImpl")
    private AdminManager admin;
    private List<Dept> list;
    private List<ProForm> proList;
    private List<CourseForm> courseList;
    private DeptForm deptForm;
    private ProForm proForm;
    private CourseForm courseForm;
    private Method msg;

    /**
     * 
     */
    private static final long serialVersionUID = -7243750676583760197L;

    public String exampleMethod() {
        return null;
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
        default:
            returnMsg = "错误页码";
            break;
        }
        return returnMsg;

    }

    // add 请求分类
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

        default:
            returnMsg = "错误页码";
            break;
        }
        return returnMsg;

    }

    // 模糊查询 院系名称
    public String searchDeptByNameForLike() {
        // 清空list
        // System.out.println(deptForm.getContent()+":");
        list = null;
        // 模糊查询deptName获取的表
        list = admin.queryByName(deptForm.getContent());
        return "dept";
    }

    // 模糊查询 专业名称
    public String searchProByNameForLike() {
        // 模糊查询professionName获取的表
        System.out.println(proForm.getContent());
        proList = admin.queryByProName(proForm.getContent());
        // 为添加 添加院系
        list = admin.getAllDept();
        return "proIndex";
    }

    /**
     * dept修改页面 确认修改
     * 
     * @return
     */
    public String exeUpdateDeptById() {
        list = admin.updateDeptByID(deptForm);
        if (list != null) {
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
        System.out.println(proForm.getProfessionNo() + proForm.getProfessionName());
        System.out.println(proForm.getSelectArr()[0]);
        proList = admin.updateProByID(proForm);
        if (proList != null) {
            // 为添加添加院系
            list = admin.getAllDept();
            return "proIndex";
        }
        // return "修改错误是返回的页面";
        return "dept";
    }

    // 删除dept
    public String delDeptById() {
        System.out.println(deptForm.getDeptNo() + "--------------");
        admin.delDeptById(deptForm.getDeptNo());
        // 刷新数据
        list = admin.getAllByPage(0, 10);
        return "dept";
    }

    // 添加dept
    public String addDept() {
        list = admin.addDept(deptForm.getDeptName());
        return "dept";
    }

    // 添加profession
    public String addPro() {
        System.out.println("addPro");
        System.out.println(proForm.getSelectArr()[0] + ":" + proForm.getProfessionNo() + ":"
                + proForm.getProfessionName());
        proList = admin.addPro(proForm);
        list = admin.getAllDept();
        // System.out.println((proList == null) + "addPro 返回的数据");
        return "proIndex";
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
        // list = admin.getAllByPage(deptForm.getPageNo(), deptForm.getPageSize());
        list = admin.getAllByPage(0, 10);
        System.out.println(list.size());
        return "dept";
    }

    /**
     * 初始进入课程页面默认显示效果
     * 
     * @return
     */
    public String getAllCourseList() {
        // list = admin.getAllByPage(deptForm.getPageNo(), deptForm.getPageSize());
        System.out.println("course default page" + courseForm.getPageNo());
        courseList = admin.getCourseByPage(courseForm.getPageNo(), 10);
        System.out.println((courseList == null) + "  :course default page");
        return "courseIndex";
    }

    /**
     * 初始进入专业页面默认显示效果
     * 
     * @return
     */
    public String getAllProList() {
        // list = admin.getAllByPage(deptForm.getPageNo(), deptForm.getPageSize());
        proList = admin.getProByPage(proForm.getPageNo() + 1, 10);
        System.out.println(proList.size() + "------------------------------");
        // 为添加的dialog 加载数据
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

}
