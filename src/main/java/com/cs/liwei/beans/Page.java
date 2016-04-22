package com.cs.liwei.beans;
/**
 * 
 * 类/接口注释
 * 
 * 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 用于分页处理
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月22日
 *
 */
public class Page {
    private int pageNo;
    private int pageSize;
    // 总共页数
    private int pageCount;
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
}
