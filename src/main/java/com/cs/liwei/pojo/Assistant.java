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
public class Assistant implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7999501729170347018L;
    /*
     * some propertype  属性
     */
    /**
     * 辅导员编号
     */
    private int assistantNo;
    /**
     * 辅导员名称
     */
    private String assistantName;
    /**
     * 辅导员密码
     */
    private String assistantPwd;
    /**
     * 院系编号
     */
    private int deptNo;
    /**
     * @return the assistantNo
     */
    public int getAssistantNo() {
        return assistantNo;
    }
    /**
     * @param assistantNo the assistantNo to set
     */
    public void setAssistantNo(int assistantNo) {
        this.assistantNo = assistantNo;
    }
    /**
     * @return the assistantName
     */
    public String getAssistantName() {
        return assistantName;
    }
    /**
     * @param assistantName the assistantName to set
     */
    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }
    /**
     * @return the assistantPwd
     */
    public String getAssistantPwd() {
        return assistantPwd;
    }
    /**
     * @param assistantPwd the assistantPwd to set
     */
    public void setAssistantPwd(String assistantPwd) {
        this.assistantPwd = assistantPwd;
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
        return "Assistant [assistantNo=" + assistantNo + ", assistantName=" + assistantName
                + ", assistantPwd=" + assistantPwd + ", deptNo=" + deptNo + "]";
    }
    
    

}
