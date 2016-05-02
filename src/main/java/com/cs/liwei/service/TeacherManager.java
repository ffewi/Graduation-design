package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.TeacherAddOrUpdateGrade;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.pojo.ClassTable;
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
     * 通过className删除
     */
    boolean delClassByClassName(String className);
    /**
     * 
     * @param teaching
     * @return
     */
    boolean delTeachingByCourseNoAndClassName(TeachingPlanForm teaching);
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
     * 通过className  根据courseName模糊查询
     * @param tpForm
     * @return
     */
    List<TeachingPlanForm>getTeachingByNameForLike(TeachingPlanForm tpForm);
    /**
     * 获取教师下拉选项
     */
    List<Teacher> getAllTeacher();
    /**
     * 获取班级下拉选项
     */
    List<ClassTable> getAllClassName();
    /**
     * 获取学期下的课程拉选项 并且加入班级筛选
     */
    List<Course> getAllCourseByTerm(int termID,String className);
    /**
     * 保存teachingplan
     * @param tpForm
     * @return
     */
    List<TeachingPlanForm> saveTeachingPlan(TeachingPlanForm tpForm);
    /**
     * 修改上课老师
     * @param tpForm
     * @return
     */
    List<TeachingPlanForm> updateTeachingJustChangeTeacher(TeachingPlanForm tpForm);
    /**
     * 获取班级管理页面默认信息，信息问全部，分页
     * @return
     */
    List<ClassForm> getClassIndexList(int pageNo);
    /**
     * 保存class
     * @param cfForm
     * @return
     */
    List<ClassForm> saveClass(ClassForm cfForm);
    /**
     * 更新class
     * @return
     */
    List<ClassForm> exeUpdateClass(ClassForm cfForm);
    /**
     * 检查教师登录
     * @param t
     * @return
     */
    Teacher checkLogin(Teacher t);
    /**
     * 教师更新密码
     * @param teacherNo
     * @param pass
     * @return
     */
    boolean changePass(int teacherNo,String pass);
    /**
     * 获取所教的班级
     * @param teacherNo
     * @return
     */
    List<String> getTeachingClassName(int teacherNo);
    /**
     * 获取老师 所选班级下 自己教的课程
     * @param tau
     * @return
     */
    List<TeacherAddOrUpdateGrade> getCourseMenuByTeacherNoAndClassName(TeacherAddOrUpdateGrade tau);
    /**
     * 获取老师可以录入的学生消息
     * @param tau
     * @return
     */
    List<TeacherAddOrUpdateGrade> getStudentLuru(TeacherAddOrUpdateGrade tau);
    /**
     * 教师录入成绩，只需要插入即可
     * @param tau
     */
    void insertStudnetScore(TeacherAddOrUpdateGrade tau);
}
