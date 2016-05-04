package com.cs.liwei.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.TeacherAddOrUpdateGrade;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.service.TeacherManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "teaAction")
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 8976661912458589520L;
    @Resource
    private TeacherManager teacher;
    private TeacherAddOrUpdateGrade tauForm;
    private Teacher tea;

    // strust2 ajax 操作
    public String ajaxClassNameChange() {
        // 获取班级下课程下拉
        // System.out.println(tauForm.getTeacherNo() + ":  " + tauForm.getClassName());
        // 获取course
        List<TeacherAddOrUpdateGrade> resultList = teacher
                .getCourseMenuByTeacherNoAndClassName(tauForm);
        if (resultList != null && !resultList.isEmpty()) {
            JSONArray json = JSONArray.fromObject(resultList);
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(json.toString());
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }
        return null;
    }

    // 录入请求 列出信息
    public String ajaxStudentluru() {
        // System.out.println("tauForm:" + tauForm.getTeacherNo() + ": " + tauForm.getClassName()
        // + ":" + tauForm.getCourseNo());
        //
        List<TeacherAddOrUpdateGrade> resultList = teacher.getStudentLuru(tauForm);
        if (resultList != null && !resultList.isEmpty()) {
            JSONArray json = JSONArray.fromObject(resultList);
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(json.toString());
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }
        return null;
    }

    // 开始录入单个成绩
    public String ajaxStudentluruCJ() {
        // System.out.println("tauForm:" + tauForm.getStudentNo() + ": " + tauForm.getCourseNo() + ":"
        // + tauForm.getPingshiScore() + ":" + tauForm.getExamScore());
        // 调用service录入成绩即可，无需返回回调函数内容
        teacher.insertStudnetScore(tauForm);
        return null;
    }

    // 开始修改单个
    public String ajaxStudentxiugaiCJ() {
        // 不做返回数据响应
        System.out.println("教师修改学生成绩！");
        teacher.updateStudnetScore(tauForm);
        return null;
    }

    // 教师模糊查询学生姓名 修改成绩
    public String ajaxSearchStudentToUpdate() {
        
        List<TeacherAddOrUpdateGrade> resultList = teacher.getStudentSeacherByStuName(tauForm);
        if (resultList != null && !resultList.isEmpty()) {
            JSONArray json = JSONArray.fromObject(resultList);
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(json.toString());
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }/*else {
            //JSONArray json = JSONArray.fromObject("");
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(" ");
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }*/
        return null;
    }

    // 修改请求 列出信息
    public String ajaxStudentxiugai() {
        // System.out.println("tauForm:" + tauForm.getTeacherNo() + ": " + tauForm.getClassName()
        // + ":" + tauForm.getCourseNo());
        // 修改请求，刚好与录入请求相反，查出已经有成绩的学生
        List<TeacherAddOrUpdateGrade> resultList = teacher.getStudentXiugai(tauForm);
        if (resultList != null && !resultList.isEmpty()) {
            JSONArray json = JSONArray.fromObject(resultList);
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(json.toString());
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }
        return null;
    }

    // 上一页 下一页 ajax请求
    public String ajaxNextPage() {
        // 修改页面上一页，下一页，只需改动pageNo即可
        List<TeacherAddOrUpdateGrade> resultList = teacher.getStudentXiugai(tauForm);
        if (resultList != null && !resultList.isEmpty()) {
            JSONArray json = JSONArray.fromObject(resultList);
            try {
                ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
                ServletActionContext.getResponse().getWriter().println(json.toString());
                // System.out.println(json.toString());
            } catch (IOException e) {
                System.out.println("json error!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String changePass() {
        // System.out.println("教师修改密码");
        // System.out.println(" no" + tea.getTeacherNo() + ": " + tea.getTeacherPwd());
        boolean result = teacher.changePass(tea.getTeacherNo(), tea.getTeacherPwd());
        if (result) {
            return "changePass";
        }

        return "密码修改错误页面";
    }

    // getter and setter
    public Teacher getTea() {
        return tea;
    }

    public void setTea(Teacher tea) {
        this.tea = tea;
    }

    public TeacherAddOrUpdateGrade getTauForm() {
        return tauForm;
    }

    public void setTauForm(TeacherAddOrUpdateGrade tauForm) {
        this.tauForm = tauForm;
    }

}
