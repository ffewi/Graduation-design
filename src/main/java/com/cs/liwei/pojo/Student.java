package com.cs.liwei.pojo;

import java.io.Serializable;

/**
 * 
 * 类/接口注释 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class Student implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5789728812150771606L;
    /*
     * some propertype 属性
     */
    /**
     * 学生学号
     */
    private int studentNo;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 密码
     */
    private String stuPass;
    /**
     * 学生状态
     */
    private int stuState;

    /**
     * @return the studentNo
     */
    public int getStudentNo() {
        return studentNo;
    }

    /**
     * @param studentNo the studentNo to set
     */
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the stuPass
     */
    public String getStuPass() {
        return stuPass;
    }

    /**
     * @param stuPass the stuPass to set
     */
    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    /**
     * @return the stuState
     */
    public int getStuState() {
        return stuState;
    }

    /**
     * @param stuState the stuState to set
     */
    public void setStuState(int stuState) {
        this.stuState = stuState;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", sex=" + sex
                + ", className=" + className + ", stuPass=" + stuPass + ", stuState=" + stuState
                + "]";
    }

}
