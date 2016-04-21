package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月18日
 *
 */
public class DeptForm {
    /*
     * 对应前台表单 传来的属性名字
     */
    // 院系编号
    private int deptNo;
    // 院系名称
    private String deptName;
    // 查询框 内容
    private String content;
    private int pageNo;
    private int pageSize;

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
}
