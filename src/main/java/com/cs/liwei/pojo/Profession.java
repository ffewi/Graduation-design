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
public class Profession implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5081563853243278713L;
    /*
     * some propertype 属性
     */
    /**
     * 专业编号
     */
    private int professionNo;
    /**
     * 专业名称
     */
    private String professionName;
    /**
     * 院系编号
     */
    private int deptNo;

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
