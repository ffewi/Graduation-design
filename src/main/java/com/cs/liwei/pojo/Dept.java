package com.cs.liwei.pojo;

import java.io.Serializable;

/**
 * 
 * 类/接口注释 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月16日
 *
 */
public class Dept implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7204901953903052017L;
    /*
     * some propertype 属性
     */
    /**
     * 学院编号
     */
    private int deptNo;
    /**
     * 学院名称
     */
    private String deptName;

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

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Dept [deptNo=" + deptNo + ", deptName=" + deptName + "]";
    }

}
