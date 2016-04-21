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
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Dept> getAllDept();
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
     * 添加dept 只需要名称，自动生成id
     */
    List<Dept> addDept(String deptName);
    /**
     * 添加profession 只需要名称，和院系编号，自动生成id
     */
    List<ProForm> addPro(ProForm proForm);
}
