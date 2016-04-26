package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月20日
 *
 */
public class ClassForm {
    /*
     * 对应前台表单 传来的属性名字
     */
    private String className;
    private int professionNo;
    private int stuTotal;
    private int assistantNo;
    private String professionName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getProfessionNo() {
        return professionNo;
    }

    public void setProfessionNo(int professionNo) {
        this.professionNo = professionNo;
    }

    public int getStuTotal() {
        return stuTotal;
    }

    public void setStuTotal(int stuTotal) {
        this.stuTotal = stuTotal;
    }

    public int getAssistantNo() {
        return assistantNo;
    }

    public void setAssistantNo(int assistantNo) {
        this.assistantNo = assistantNo;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String profesionName) {
        this.professionName = profesionName;
    }

}
