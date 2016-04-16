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
public class Teacher implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2921755817585730426L;
    /*
     * some propertype  属性
     */
    /**
     * 教师编号
     */
    private int teacherNo;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 职称
     */
    private String positionCall;
    /**
     * 性别
     */
    private String sex;
    /**
     * 教师密码
     */
    private String teacherPwd;
    /**
     * 院系编号
     */
    private int deptNo;
    /**
     * @return the teacherNo
     */
    public int getTeacherNo() {
        return teacherNo;
    }
    /**
     * @param teacherNo the teacherNo to set
     */
    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
    }
    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }
    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    /**
     * @return the positionCall
     */
    public String getPositionCall() {
        return positionCall;
    }
    /**
     * @param positionCall the positionCall to set
     */
    public void setPositionCall(String positionCall) {
        this.positionCall = positionCall;
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
     * @return the teacherPwd
     */
    public String getTeacherPwd() {
        return teacherPwd;
    }
    /**
     * @param teacherPwd the teacherPwd to set
     */
    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }
    /**
     * @return the deptNo
     */
    public int getDeptNo() {
        return deptNo;
    }
    /**
     * @param deptNo the deptNo to set
     */
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    
    
}
