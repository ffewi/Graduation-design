package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释
 * 
 * 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月21日
 *
 */
public class TeachingPlanForm {
    /*
     * 对应前台表单 传来的属性名字
     */
    private int courseNo;
    private String courseName;
    private String className;
    private int teacherNo;
    private String teacherName;
    private int term;
    // 模糊搜索内容
    private String content;

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
