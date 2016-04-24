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
    /** 添加teacher消息 */
    public static final int ADD_TEACHER = 4;
    /** 添加student消息 */
    public static final int ADD_STUDENT = 5;
    /** 分页dept消息 */
    public static final int PAGE_DETP = 1;
    /** 分页profession消息 */
    public static final int PAGE_PROFESSION = 2;
    /** 分页course消息 */
    public static final int PAGE_COURSE = 3;
    /** 分页teacher消息 */
    public static final int PAGE_TEACHER = 4;
    /** 分页assistant消息 */
    public static final int PAGE_ASSISTANT = 5;
    /** 分页mishu消息 */
    public static final int PAGE_MISHU = 6;
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
