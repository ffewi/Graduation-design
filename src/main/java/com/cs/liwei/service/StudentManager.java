package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.beans.StudentForm;

public interface StudentManager {
    /**
     * some interface method
     */
    void example();
    /**
     * 添加student
     * 
     * @param stuForm
     * @return
     */
    List<StudentForm> addStudent(StudentForm stuForm);
    /**
     * 根据studentNo 更新
     * @param stuForm
     * @return
     */
    List<StudentForm> updateStudentByID(StudentForm stuForm);
    /**
     * 通过studentNo删除学生
     * @param studentNo
     * @return
     */
    boolean delStudentById(int studentNo);
    /**
     *  模糊查询 ，通过学生名称
     *  
     */
    List<StudentForm> queryByStudentName(String name);
}
