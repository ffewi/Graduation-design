package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.pojo.Student;

/**
 * 
 * 类/接口注释
 * DAO层  方法 定义
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public interface IStudentDao extends IBaseDao {
    /*
     * 增 删 改 查
     * 定义一些其他特殊的操作
     */
    void searchAllExample();
    /**
     * 通过班级号获得专业名称
     * @param proNo
     * @return
     */
    String getProNameByClassName(String className);
    /**
     * 更新数据，需要传入 studentNo,studentName,className,sex,四项
     * 
     * @param stu
     * @return
     */
    boolean updateStudent(Student stu);
    /**
     * 删除studentBy studentNo
     * @param studentNo
     * @return
     */
    boolean delStudent(int studentNo);
    /**
     * dao层
     * 模糊查询学生名称
     * @param name
     * @return
     */
    List<StudentForm> getStudentByNameForLike(String name);
}
