package com.cs.liwei.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.dao.IStudentDao;
import com.cs.liwei.pojo.Student;
import com.cs.liwei.service.StudentManager;

@Service
public class StudentMangerImpl implements StudentManager {
    /**
     * 注入 dao
     * 
     * @resource daoName private dao
     */
    @Resource
    private IStudentDao dao;

    @Override
    public void example() {
        // TODO Auto-generated method stub
        /*
         * 一些逻辑方法，并调用dao层 进行数据分析
         */
    }

    @Override
    public List<StudentForm> addStudent(StudentForm stuForm) {
        // 调用dao层 进行添加
        Student stu = new Student();
        stu.setStudentNo(stuForm.getStudentNo());
        stu.setStudentName(stuForm.getStudentName());
        stu.setSex(stuForm.getSex());
        stu.setClassName(stuForm.getClassName());
        stu.setStuPass("123456");
        stu.setStuState(1);
        System.out.println("kaishi  insert");
        Integer stuId = dao.save(stu);
        System.out.println("get professionNAME!");
        String proName = dao.getProNameByClassName(stuForm.getClassName());
        stuForm.setStudentNo(stuId);
        stuForm.setProfessionName(proName);
        List<StudentForm> list = new ArrayList<StudentForm>();
        list.add(stuForm);
        return list;
    }

    @Override
    public List<StudentForm> updateStudentByID(StudentForm stuForm) {
        // 更新数据
        Student stu = new Student();
        stu.setStudentNo(stuForm.getStudentNo());
        stu.setStudentName(stuForm.getStudentName());
        stu.setSex(stuForm.getSex());
        stu.setClassName(stuForm.getClassName());
        System.out.println(stu);
        // 调用dao层 更新
        boolean result = dao.updateStudent(stu);
        if (result) {
            List<StudentForm> list = new ArrayList<StudentForm>();
            String proName = dao.getProNameByClassName(stuForm.getClassName());
            stuForm.setProfessionName(proName);
            list.add(stuForm);
            return list;
        }
        return null;
    }

    @Override
    public boolean delStudentById(int studentNo) {
        // 调用dao层 开始删除
        boolean isOk = dao.delStudent(studentNo);
        if (isOk) {
            return true;
        }
        return false;
    }

    @Override
    public List<StudentForm> queryByStudentName(String name) {
        // 调用daoceng 查询 模糊查询
        List<StudentForm> list = dao.getStudentByNameForLike(name);
        return list;
    }

}
