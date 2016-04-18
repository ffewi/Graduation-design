package com.cs.liwei.pojo;

import java.io.Serializable;

/**
 * 
 * 类/接口注释 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月18日
 *
 */
public class Mishu implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2906377392665663314L;
    /*
     * some propertype 属性
     */
    /**
     * 秘书编号
     */
    private int mishuNo;
    /**
     * 秘书名称
     */
    private String mishuName;
    /**
     * 秘书密码
     */
    private String mishuPwd;
    /**
     * 院系编号
     */
    private int deptNo;
    /**
     * @return the mishuNo
     */
    public int getMishuNo() {
        return mishuNo;
    }
    /**
     * @param mishuNo the mishuNo to set
     */
    public void setMishuNo(int mishuNo) {
        this.mishuNo = mishuNo;
    }
    /**
     * @return the mishuName
     */
    public String getMishuName() {
        return mishuName;
    }
    /**
     * @param mishuName the mishuName to set
     */
    public void setMishuName(String mishuName) {
        this.mishuName = mishuName;
    }
    /**
     * @return the mishuPwd
     */
    public String getMishuPwd() {
        return mishuPwd;
    }
    /**
     * @param mishuPwd the mishuPwd to set
     */
    public void setMishuPwd(String mishuPwd) {
        this.mishuPwd = mishuPwd;
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
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Mishu [mishuNo=" + mishuNo + ", mishuName=" + mishuName + ", mishuPwd=" + mishuPwd
                + ", deptNo=" + deptNo + "]";
    }

    
}
