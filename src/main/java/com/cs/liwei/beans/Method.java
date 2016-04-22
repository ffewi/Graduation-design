package com.cs.liwei.beans;
/**
 * 
 * 类/接口注释
 * 页面请求是 的方法类别
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月20日
 *
 */
public class Method {
    /** 添加dept消息 */
    public static final int ADD_DEPT = 1;
    /** 添加profession消息 */
    public static final int ADD_PROFESSION = 2;
    /** 添加course消息 */
    public static final int ADD_COURSE = 3;
    /** 分页dept消息 */
    public static final int PAGE_DETP = 1;
    /** 分页profession消息 */
    public static final int PAGE_PROFESSION = 2;
    /** 分页course消息 */
    public static final int PAGE_COURSE = 3;
    /** 请求方法参数接受器*/ 
    private int method;

    /**
     * @return the method
     */
    public int getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(int method) {
        this.method = method;
    }
    
    
}
