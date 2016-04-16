package com.cs.liwei.pojo;

import java.io.Serializable;

/**
 * 
 * 类/接口注释
 * 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月16日
 *
 */
public class ClassTable implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1696104400258596383L;
    /*
     * some propertype  属性
     */
    /**
     * 班级名称
     */
    private String className;
    /**
     * 专业编号
     */
    private int professionNo;
    /**
     * 辅导员编号
     */
    private int assisantNo;
    /**
     * 学生总人数
     */
    private int stuTotal;
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
     * @return the assisantNo
     */
    public int getAssisantNo() {
        return assisantNo;
    }
    /**
     * @param assisantNo the assisantNo to set
     */
    public void setAssisantNo(int assisantNo) {
        this.assisantNo = assisantNo;
    }
    /**
     * @return the stuTotal
     */
    public int getStuTotal() {
        return stuTotal;
    }
    /**
     * @param stuTotal the stuTotal to set
     */
    public void setStuTotal(int stuTotal) {
        this.stuTotal = stuTotal;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassTable [className=" + className + ", professionNo=" + professionNo
                + ", assisantNo=" + assisantNo + ", stuTotal=" + stuTotal + "]";
    }
    
    
}
