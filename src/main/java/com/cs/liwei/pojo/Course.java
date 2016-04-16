package com.cs.liwei.pojo;

import java.io.Serializable;
/**
 * 
 * 类/接口注释
 * 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class Course implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7871746228963310311L;
    
    /*
     * some propertype  属性
     */
    /**
     * 课程编号
     */
    private int courseNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程类型
     */
    private String courseType;
    /**
     * 学分
     */
    private int credit;
    /**
     * 专业编号
     */
    private int professionNo;
    /**
     * 学期
     */
    private int term;
    /**
     * @return the courseNo
     */
    public int getCourseNo() {
        return courseNo;
    }
    /**
     * @param courseNo the courseNo to set
     */
    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }
    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * @return the courseType
     */
    public String getCourseType() {
        return courseType;
    }
    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    /**
     * @return the credit
     */
    public int getCredit() {
        return credit;
    }
    /**
     * @param credit the credit to set
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }
    /**
     * @return the professionNo
     */
    public int getProfessionNo() {
        return professionNo;
    }
    /**
     * @param professionNo the professionNo to set
     */
    public void setProfessionNo(int professionNo) {
        this.professionNo = professionNo;
    }
    /**
     * @return the term
     */
    public int getTerm() {
        return term;
    }
    /**
     * @param term the term to set
     */
    public void setTerm(int term) {
        this.term = term;
    }
    
    
}
