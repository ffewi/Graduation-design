package com.cs.liwei.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.Page;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.beans.ScoreForm;
import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.pojo.ClassTable;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.service.AdminManager;
import com.cs.liwei.service.StudentManager;
import com.cs.liwei.service.TeacherManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "adminMember")
@Scope(value = "prototype")
public class AdminMember extends ActionSupport {
    @Resource
    private TeacherManager teacher;
    @Resource
    private StudentManager student;
    @Resource
    private AdminManager admin;

    // 页面内容存值
    private List<TeacherForm> teaList;
    private List<Dept> list;
    private List<Teacher> teacherList;
    private List<Course> courseList;
    private List<ClassTable> classList;
    private List<StudentForm> stuList;
    private List<TeachingPlanForm> tpList;
    private List<ClassForm> cfList;
    private List<ScoreForm> scoreList;
    private List<ProForm> proList;
    private TeacherForm teacherForm;
    private StudentForm studentForm;
    private TeachingPlanForm tpForm;
    private ClassForm cfForm;
    private ScoreForm scoreForm;
    private Page pageMsg;
    private Method msg;

    /**
	 * 
	 */
    private static final long serialVersionUID = 5512566885571007850L;

    public String exampleMethod() {
        System.out.println("这是个测试");
        return "adminMember";
    }

    // 测试ajax
    public String getTerm() {
        System.out.println("ajax----------test!" + ":" + tpForm.getTerm() + ":"
                + tpForm.getClassName());
        courseList = teacher.getAllCourseByTerm(tpForm.getTerm(), tpForm.getClassName());
        for (Course course : courseList) {
            System.out.println(course);
        }
        JSONArray json = JSONArray.fromCollection(courseList);
        System.out.println(json.toString());
        try {
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().println(json.toString());
        } catch (IOException e) {
            System.out.println("json error!");
            e.printStackTrace();
        }
        return null;
    }

    // 修改页面跳转
    public String update() {
        String returnMsg = "";
        switch (msg.getMethod()) {
        case 1:
            // 老师修改也跳转
            list = admin.getAllDept();
            returnMsg = "teacherUpdate";
            break;
        case 2:
            // student修改也跳转
            returnMsg = "studentUpdate";
            break;
        case 3:
            // teaching修改也跳转
            teacherList = teacher.getAllTeacher();
            returnMsg = "teachingUpdate";
            break;
        case 4:
            // class修改也跳转
            System.out.println("calssUPDAE---------------------");
            proList = admin.getAllProfessionNameIndex();
            returnMsg = "classUpdate";
            break;
        case 5:
            // score修改也跳转
            returnMsg = "scoreUpdate";
            break;

        default:
            break;
        }
        return returnMsg;
    }

    public String add() {
        String returnMsg = "";
        switch (msg.getMethod()) {
        case Method.ADD_TEACHER:
            list = admin.getAllDept();
            returnMsg = "teacherAdd";
            break;
        case Method.ADD_STUDENT:
            // 其实这里应该准备className数据，但是我比较懒，写死算了
            returnMsg = "studentAdd";
            break;
        case Method.ADD_TEACHING:
            // 获取所有老师
            teacherList = teacher.getAllTeacher();
            // 获取学期下面的课程
            System.out.println("className: add teaching:" + tpForm.getClassName());
            courseList = teacher.getAllCourseByTerm(1, tpForm.getClassName());
            // 其实这里应该准备className数据，但是我比较懒，写死算了
            returnMsg = "teachingAdd";
            break;
        case Method.ADD_CLASS:
            // 准备专业信息
            proList = admin.getAllProfessionNameIndex();
            returnMsg = "classAdd";
            break;
        case Method.ADD_SCORE:
            // 准备没有成绩课程信息
            scoreList = student.getIsNotHaveCoureIndex(scoreForm.getStudentNo());
            returnMsg = "scoreAdd";
            break;
        default:
            break;
        }

        return returnMsg;
    }

    // 执行更新操作 teacher
    public String exeUpdateTeacher() {

        System.out.println("teacherUpdate!");
        teaList = teacher.updateDeptByID(teacherForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "teacherIndex";
    }

    // 更新score
    public String exeUpdateScore() {
        scoreList = student.exeUpdateScore(scoreForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "scoreIndex";
    }

    // 执行更新teaching
    public String exeUpdateTeaching() {
        System.out.println(tpForm.getClassName() + ":" + tpForm.getCourseNo() + ":"
                + tpForm.getTeacherNo() + "：" + tpForm.getTerm());
        // 修改，只修改上课老师
        tpList = teacher.updateTeachingJustChangeTeacher(tpForm);
        classList = teacher.getAllClassName();
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "teachingIndex";
    }

    // 获取老师默认页面
    public String getAllTeacherList() {
        System.out.println("adminMember");
        teaList = teacher.getAllTeacherList(pageMsg.getPageNo(), 10);
        System.out.println(teaList.size());
        pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_TEACHER));
        return "teacherIndex";
    }

    // 获取student默认页面，进入时，页面为空
    public String getStudentIndex() {
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(0);
        pageMsg.setPageCount(0);
        return "studentIndex";
    }

    // 获取成绩默认页面，进入时，页面为空
    public String getScoreIndex() {
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(0);
        pageMsg.setPageCount(0);
        return "scoreIndex";
    }

    // 获取student默认页面，进入时，页面为空
    public String getTeachingPlanIndex() {
        tpList = teacher.getTeachingPlanByClassName(tpForm);
        classList = teacher.getAllClassName();
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (tpList == null || tpList.size() == 0) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        return "teachingIndex";
    }

    // 获取班级默认页面
    public String getClassIndex() {
        System.out.println("classIndex!--------------------");
        cfList = teacher.getClassIndexList(pageMsg.getPageNo());
        pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_CLASS));
        return "classIndex";
    }

    // 添加老师
    public String addTeacher() {
        teaList = teacher.addTeacher(teacherForm);
        list = admin.getAllDept();
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "teacherIndex";
    }

    // 添加student
    public String addStudent() {
        stuList = student.addStudent(studentForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "studentIndex";
    }

    // 添加score
    public String addScore() {
        System.out.println(scoreForm.getStudentNo() + ":" + scoreForm.getPingshiScore() + ":"
                + scoreForm.getExamScore() + scoreForm.getCourseNo());
        scoreList = student.addScoreByScore(scoreForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "scoreIndex";
    }

    // 添加class
    public String addClass() {
        System.out.println(cfForm.getClassName() + ":" + cfForm.getProfessionNo() + ":"
                + cfForm.getStuTotal());
        cfList = teacher.saveClass(cfForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "classIndex";
    }

    // 添加teaching
    public String addTeaching() {
        System.out.println(tpForm.getClassName() + ":" + tpForm.getTerm() + ":"
                + tpForm.getTeacherNo() + ":" + tpForm.getCourseNo());
        // 保存教学制定 saveTeachingPlan；
        tpList = teacher.saveTeachingPlan(tpForm);
        classList = teacher.getAllClassName();
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (tpList == null || tpList.size() == 0) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        return "teachingIndex";
    }

    // 执行 studentUpdate
    public String exeUpdateStudent() {
        stuList = student.updateStudentByID(studentForm);
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "studentIndex";
    }

    // 删除 teacher
    public String delTeacherById() {
        System.out.println(teacherForm.getTeacherNo() + "===================");
        boolean result = teacher.delTeacherById(teacherForm.getTeacherNo());
        if (result) {
            teaList = teacher.getAllTeacherList(pageMsg.getPageNo(), 10);
            pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_TEACHER));
            return "teacherIndex";
        } else {
            return "执行错误的页面！";
        }

    }

    // 删除student
    public String delStudentById() {
        boolean del = student.delStudentById(studentForm.getStudentNo());
        if (del) {
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
            return "studentIndex";
        }
        return "错误页面";
    }

    // 删除class
    public String delClassByClassName() {
        boolean isOk = teacher.delClassByClassName(cfForm.getClassName());
        if (isOk) {
            cfList = teacher.getClassIndexList(pageMsg.getPageNo());
            pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_CLASS));
        }
        return "classIndex";
    }
//删除score 
    public String delScoreByStuAndCou(){
        boolean rs = student.delScoreByStuAndCou(scoreForm);
        if (rs) {
            scoreList = student.queryByStudentNoAndIsHaveGrade(scoreForm.getStudentNo());
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        return "scoreIndex";
    }
    // 删除teaching
    public String delTeachingByCourseNoAndClassName() {
        System.out.println(":---" + tpForm.getClassName() + ":" + tpForm.getCourseNo());
        // 调用删除
        boolean isOk = teacher.delTeachingByCourseNoAndClassName(tpForm);
        // 刷新数据
        if (isOk) {
            tpList = teacher.getTeachingPlanByClassName(tpForm);
            classList = teacher.getAllClassName();
            if (pageMsg == null) {
                pageMsg = new Page();
            }
            if (tpList == null || tpList.size() == 0) {
                pageMsg.setPageNo(0);
                pageMsg.setPageCount(0);
            } else {
                pageMsg.setPageNo(1);
                pageMsg.setPageCount(1);
            }
        }

        return "teachingIndex";
    }

    // 模糊查询老师姓名
    public String searchTeacherByNameForLike() {
        teaList = teacher.queryByTeacherName(teacherForm.getContent());
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (teaList == null || teaList.size() == 0) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        list = admin.getAllDept();
        return "teacherIndex";
    }

    // 模糊查询学生姓名
    public String searchStudentByNameForLike() {
        // teaList = teacher.queryByTeacherName(teacherForm.getContent());
        stuList = student.queryByStudentName(studentForm.getContent());
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (stuList == null || stuList.size() == 0) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }
        list = admin.getAllDept();
        return "studentIndex";
    }

    // 模糊查询teaching by className
    public String searchTeachingByNameForLike() {
        System.out.println("hello-------------" + tpForm.getContent() + ":  "
                + tpForm.getClassName());
        // 调用查询
        tpList = teacher.getTeachingByNameForLike(tpForm);
        classList = teacher.getAllClassName();
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        if (tpList == null || tpList.size() == 0) {
            pageMsg.setPageNo(0);
            pageMsg.setPageCount(0);
        } else {
            pageMsg.setPageNo(1);
            pageMsg.setPageCount(1);
        }

        return "teachingIndex";
    }

    // 精确查询学生
    public String searchScoreByStuNo() {
        System.out.println(scoreForm.getStudentNo());
        scoreList = student.queryByStudentNoAndIsHaveGrade(scoreForm.getStudentNo());
        if (pageMsg == null) {
            pageMsg = new Page();
        }
        pageMsg.setPageNo(1);
        pageMsg.setPageCount(1);
        return "scoreIndex";
    }

    // getter and setter method

    public Page getPageMsg() {
        return pageMsg;
    }

    public List<TeacherForm> getTeaList() {
        return teaList;
    }

    public void setTeaList(List<TeacherForm> teaList) {
        this.teaList = teaList;
    }

    public void setPageMsg(Page pageMsg) {
        this.pageMsg = pageMsg;
    }

    public Method getMsg() {
        return msg;
    }

    public void setMsg(Method msg) {
        this.msg = msg;
    }

    public List<Dept> getList() {
        return list;
    }

    public void setList(List<Dept> list) {
        this.list = list;
    }

    public TeacherForm getTeacherForm() {
        return teacherForm;
    }

    public void setTeacherForm(TeacherForm teacherForm) {
        this.teacherForm = teacherForm;
    }

    public List<StudentForm> getStuList() {
        return stuList;
    }

    public void setStuList(List<StudentForm> stuList) {
        this.stuList = stuList;
    }

    public StudentForm getStudentForm() {
        return studentForm;
    }

    public void setStudentForm(StudentForm studentForm) {
        this.studentForm = studentForm;
    }

    public TeachingPlanForm getTpForm() {
        return tpForm;
    }

    public void setTpForm(TeachingPlanForm tpForm) {
        this.tpForm = tpForm;
    }

    public List<TeachingPlanForm> getTpList() {
        return tpList;
    }

    public void setTpList(List<TeachingPlanForm> tpList) {
        this.tpList = tpList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<ClassTable> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassTable> classList) {
        this.classList = classList;
    }

    public ClassForm getCfForm() {
        return cfForm;
    }

    public void setCfForm(ClassForm cfForm) {
        this.cfForm = cfForm;
    }

    public List<ClassForm> getCfList() {
        return cfList;
    }

    public void setCfList(List<ClassForm> cfList) {
        this.cfList = cfList;
    }

    public List<ProForm> getProList() {
        return proList;
    }

    public void setProList(List<ProForm> proList) {
        this.proList = proList;
    }

    public List<ScoreForm> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<ScoreForm> scoreList) {
        this.scoreList = scoreList;
    }

    public ScoreForm getScoreForm() {
        return scoreForm;
    }

    public void setScoreForm(ScoreForm scoreForm) {
        this.scoreForm = scoreForm;
    }

}
