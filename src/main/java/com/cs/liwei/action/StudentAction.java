package com.cs.liwei.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.Page;
import com.cs.liwei.beans.StuShowGrade;
import com.cs.liwei.beans.StudentDetail;
import com.cs.liwei.pojo.Student;
import com.cs.liwei.service.StudentManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "stuAction")
@Scope(value = "prototype")
public class StudentAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 2698844706433754829L;
    @Resource
    private StudentManager student;

    private List<Integer> termList;
    private List<StuShowGrade> ssgList;
    private StuShowGrade ssgForm;
    private Student stu;
    private Student stuMsg;
    private Page pageMsg;
    private StudentDetail sd;

    public String exampleMethod() {

        return "pageName";
    }

    public String ajaxTermChange() {
        // 下来改变学期 信息table 改变
        // System.out.println(ssgForm.getStudentNo() + ":  " + ssgForm.getTerm());
        ssgList = student.getStuMsgByTermAndByPageNo(ssgForm.getStudentNo(), ssgForm.getTerm(), 1);
        JSONArray json = JSONArray.fromObject(ssgList);
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(json.toString());
            // System.out.println(json.toString());
        } catch (IOException e) {
            System.out.println("json error!");
            e.printStackTrace();
        }
        return null;
    }

    public String ajaxSearchByCourName() {
        // 模糊查询课程名称
        // System.out.println("页面传来的数据：" + ssgForm.getTerm() + ": "
        // + ssgForm.getStudentNo() + ": " + ssgForm.getCourseName());
        ssgList = student.searchStuMsgByTermAndByCourseName(ssgForm.getStudentNo(),
                ssgForm.getTerm(), ssgForm.getCourseName());
        JSONArray json = JSONArray.fromObject(ssgList);
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(json.toString());
            // System.out.println(json.toString());
        } catch (IOException e) {
            System.out.println("json error!");
            e.printStackTrace();
        }
        return null;
    }

    public String ajaxNextPage() {
        // System.out.println(ssgForm.getStudentNo() + ":  " + ssgForm.getTerm()
        // + ": " + pageMsg.getPageNo());
        ssgList = student.getStuMsgByTermAndByPageNo(ssgForm.getStudentNo(), ssgForm.getTerm(),
                pageMsg.getPageNo());
        JSONArray json = JSONArray.fromObject(ssgList);
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(json.toString());
            // System.out.println(json.toString());
        } catch (IOException e) {
            System.out.println("json error!");
            e.printStackTrace();
        }
        return null;
    }

    public String indexPage() {
        // System.out.println("comming--------------------studentIndex");
        // 获取数据
        termList = student.getTermdropDownMenu(stu.getStudentNo());
        if (termList != null) {
            Integer firstIndex = termList.get(0);
            ssgList = student.getStuMsgByTermAndByPageNo(stu.getStudentNo(), firstIndex, 1);
            if (ssgList != null) {
                StuShowGrade obj = ssgList.get(0);
                int total = obj.getPageNum() / 8;
                int c = obj.getPageNum() % 8 == 0 ? total : total + 1;
                // System.out.println("此学期成绩总页数：" + c + "  pageNum:"
                // + obj.getPageNum());
                if (pageMsg == null) {
                    pageMsg = new Page();
                }
                pageMsg.setPageCount(c);
                pageMsg.setPageNo(1);
            }
        } else {
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageCount(0);
            pageMsg.setPageNo(0);
        }

        return "studentIndex";
    }

    public String welcomPage() {
        sd = student.getStudentTotalCountDetail(stu.getStudentNo());
        if (stuMsg == null) {
            stuMsg = new Student();
        }
        stuMsg.setStudentNo(stu.getStudentNo());
        return "studentWelcomPage";
    }

    public String changePass() {
        // System.out.println(stu.getStudentNo() + ":  " + stu.getStuPass());
        boolean isOk = student.changePassword(stu.getStudentNo(), stu.getStuPass());
        if (isOk) {
            return "changePass";
        }
        return "密码修改出错页面";
    }

    public List<Integer> getTermList() {
        return termList;
    }

    public void setTermList(List<Integer> termList) {
        this.termList = termList;
    }

    public List<StuShowGrade> getSsgList() {
        return ssgList;
    }

    public void setSsgList(List<StuShowGrade> ssgList) {
        this.ssgList = ssgList;
    }

    public StuShowGrade getSsgForm() {
        return ssgForm;
    }

    public void setSsgForm(StuShowGrade ssgForm) {
        this.ssgForm = ssgForm;
    }

    public Page getPageMsg() {
        return pageMsg;
    }

    public void setPageMsg(Page pageMsg) {
        this.pageMsg = pageMsg;
    }

    /**
     * @return the sd
     */
    public StudentDetail getSd() {
        return sd;
    }

    /**
     * @param sd the sd to set
     */
    public void setSd(StudentDetail sd) {
        this.sd = sd;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public Student getStuMsg() {
        return stuMsg;
    }

    public void setStuMsg(Student stuMsg) {
        this.stuMsg = stuMsg;
    }

}
