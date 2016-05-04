package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.DeptForm;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;

public interface AdminManager {
    /**
     * some interface method
     */
    void example();

    /**
     * 获取dept 按照指定的页面 及其 页面大小 显示
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Dept> getAllByPage(int pageNo, int pageSize);
    
    /**
     * 获取dept 所有信息
     * 
     * @return
     */
    List<Dept> getAllDept();
    
    /**
     * 获取profeesion 所有信息
     * 
     * @return
     */
    List<ProForm> getAllProfessionNameIndex();
    /**
     * 获取profession 按照指定的页面 及其 页面大小 显示
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ProForm> getProByPage(int pageNo, int pageSize);
    /**
     * 获取course 按照指定的页面 及其 页面大小 显示
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<CourseForm> getCourseByPage(int pageNo, int pageSize);
    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Dept> queryByName(String name);
    /**
     * 模糊查询 profession
     * @param name
     * @return
     */
    List<ProForm> queryByProName(String name);
    /**
     * 模糊查询 course
     * @param name
     * @return
     */
    List<CourseForm> queryByCourseName(String name);
    /**
     * 更新dept 的信息 通过id
     * @param deptMsg
     * @return
     */
    List<Dept> updateDeptByID(DeptForm deptMsg);
    /**
     * 更新profession 的信息 通过id
     * @param deptMsg
     * @return
     */
    List<ProForm> updateProByID(ProForm proMsg);
    /**
     * 更新course 的信息 通过id
     * @param deptMsg
     * @return
     */
    List<CourseForm> updateCourseByID(CourseForm courseMsg);
    /**
     * 登录检查 admin
     * 成功：true  不成功：false
     * @param admin
     * @return
     */
    boolean checkLogin(Admin admin);
    /**
     * 删除dept 通过主键deptNo
     */
    void delDeptById(int deptNo);
    /**
     * 删除profession 通过主键professionNo
     */
    void delProById(int professionNo);
    /**
     * 删除course 通过主键courseNo
     */
    void delCourseById(int courseNo);
    /**
     * 添加dept 只需要名称，自动生成id
     */
    List<Dept> addDept(String deptName);
    /**
     * 添加profession 只需要名称，和院系编号，自动生成id
     */
    List<ProForm> addPro(ProForm proForm);
    /**
     * 添加course 只需要名称，和专业编号，学分，学期，类型，自动生成id
     */
    List<CourseForm> addCourse(CourseForm courseForm);
    /**
     * 通过com.cs.liwei.bean.Method 里面的常量
     * 分类统计页面大小
     * @param categoryOfMethod
     * @return
     */
    int getPageTotal(int categoryOfMethod);
    /**
     * 判断用存在否
     * @param ad
     * @param type
     * @return
     */
    boolean isHaveUser(Admin ad,int type);
    /**
     * 修改所有角色密码，用过type值决定，0:admin 1:teacher 2:student
     * @param ad
     * @param type
     * @return
     */
    boolean xiugaiPass(Admin ad,int type);
}
