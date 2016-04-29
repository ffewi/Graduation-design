package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释
 * 
 * 
 * 此处 bean定义为页面与后台交互时数据 存储 的对象载体 student 查看成绩页面信息载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月29日
 *
 */
public class StuShowGrade {
    private int studentNo;
    private int courseNo;
    private int finalScore;
    private float gradePoint;
    private int credit;
    private String className;
    private String courseName;
    private int teacherNo;
    private String teacherName;
    private int term;

    // 以term区分 的 数据量
    private int pageNum;

    
    
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public float getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(float gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

}
