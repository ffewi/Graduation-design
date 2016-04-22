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
public class CourseForm {
    /*
     * 对应前台表单 传来的属性名字
     */
    private int courseNo;
    private String courseName;
    private String courseType;
    private int credit;
    private int professionNo;
    private String professionName;
    private int term;
    // 查询框 内容
    private String content;
    private int pageNo;
    private int pageSize;
    // 总共页数
    private int pageCount;
    // 下拉选择框取值 专业名
    private int[] selectProNo;
    // 下拉选择框取值 课程类型
    private String[] selectType;
    // 下拉选择框取值 学分
    private int[] selectCredit;
    // 下拉选择框取值 学期
    private int[] selectTerm;

    public int[] getSelectProNo() {
        return selectProNo;
    }

    public void setSelectProNo(int[] selectProNo) {
        this.selectProNo = selectProNo;
    }

    public String[] getSelectType() {
        return selectType;
    }

    public void setSelectType(String[] selectType) {
        this.selectType = selectType;
    }

    public int[] getSelectCredit() {
        return selectCredit;
    }

    public void setSelectCredit(int[] selectCredit) {
        this.selectCredit = selectCredit;
    }

    public int[] getSelectTerm() {
        return selectTerm;
    }

    public void setSelectTerm(int[] selectTerm) {
        this.selectTerm = selectTerm;
    }

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
     * @return the professionName
     */
    public String getProfessionName() {
        return professionName;
    }

    /**
     * @param professionName the professionName to set
     */
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
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

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
