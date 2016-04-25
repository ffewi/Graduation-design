package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Teacher;

public interface TeacherManager {
    /**
     * some interface method
     */
    void example();
    /**
     * 添加student 只需要名称，和院系编号，职称，性别
     */
    List<TeacherForm> addTeacher(TeacherForm teacherForm);
    /**
     * 获取老师管理 页面基本老师信息  按分页显示
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<TeacherForm> getAllTeacherList(int pageNo,int pageSize);
    /**
     * 更新teacher 的信息 通过id
     * @param teacherMsg
     * @return
     */
    List<TeacherForm> updateDeptByID(TeacherForm teacherMsg);
    /**
     * 通过com.cs.liwei.bean.Method 里面的常量
     * 包含 老师， *（看看时间够不，不够后面两个去掉）   辅导员，秘书分类
     * 分类统计页面大小
     * @param categoryOfMethod
     * @return
     */
    int getPageTotal(int categoryOfMethod);
    /**
     * 通过teacherNo删除
     */
    boolean delTeacherById(int teacherNo);
    /**
     *  模糊查询 ，通过老师名称
     *  
     */
    List<TeacherForm> queryByTeacherName(String name);
    /**
     * 通过className 取得某班级的教学制定计划
     * @param tpForm
     * @return
     */
    List<TeachingPlanForm> getTeachingPlanByClassName(TeachingPlanForm tpForm);
    /**
     * 获取教师下拉选项
     */
    List<Teacher> getAllTeacher();
    /**
     * 获取学期下的课程拉选项
     */
    List<Course> getAllCourseByTerm(int termID);
}
