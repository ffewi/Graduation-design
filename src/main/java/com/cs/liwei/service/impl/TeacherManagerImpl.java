package com.cs.liwei.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.dao.ITeacherDao;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.pojo.Teaching;
import com.cs.liwei.service.TeacherManager;

@Service
public class TeacherManagerImpl implements TeacherManager {
    /**
     * 注入 dao
     * 
     * @resource daoName private dao
     */
    @Resource(name = "teacherDaoImpl")
    private ITeacherDao dao;

    @Override
    public void example() {
        // TODO Auto-generated method stub

        /*
         * 一些逻辑方法，并调用dao层 进行数据分析
         */
    }

    @Override
    public List<TeacherForm> getAllTeacherList(int pageNo, int pageSize) {
        // 调用 teacher DAO层 操作数据库
        List<TeacherForm> list = dao.getTeacherByPage(pageNo, pageSize);
        return list;
    }

    @Override
    public int getPageTotal(int categoryOfMethod) {
        int pages = 0;
        switch (categoryOfMethod) {
        case Method.PAGE_TEACHER:
            int totalTeacher = dao.countTeacher();
            pages = (totalTeacher % 10 == 0) ? (totalTeacher / 10) : (totalTeacher / 10) + 1;
            break;
        case Method.PAGE_ASSISTANT:
            int totalAssistant = 0; // = dao.countPro();
            pages = (totalAssistant % 10 == 0) ? (totalAssistant / 10) : (totalAssistant / 10) + 1;
            break;
        case Method.PAGE_MISHU:
            int totalMishu = 0; // = dao.countCourse();
            pages = (totalMishu % 10 == 0) ? (totalMishu / 10) : (totalMishu / 10) + 1;
            break;

        default:
            break;
        }
        return pages;
    }

    @Override
    public List<TeacherForm> addTeacher(TeacherForm teacherForm) {
        // 添加老师
        Teacher tea = new Teacher();
        tea.setTeacherName(teacherForm.getTeacherName());
        tea.setPositionCall(teacherForm.getPositionCall());
        tea.setSex(teacherForm.getSex());
        tea.setTeacherPwd("123456");
        tea.setDeptNo(teacherForm.getDeptNo());
        Integer teaId = dao.save(tea);
        Dept obj = new Dept();
        Dept dept = (Dept) dao.findByID(obj, teacherForm.getDeptNo());
        teacherForm.setTeacherNo(teaId);
        teacherForm.setDeptName(dept.getDeptName());
        List<TeacherForm> list = new ArrayList<TeacherForm>();
        list.add(teacherForm);
        return list;
    }

    @Override
    public List<TeacherForm> updateDeptByID(TeacherForm teacherMsg) {
        Teacher tea = new Teacher();
        tea.setTeacherNo(teacherMsg.getTeacherNo());
        tea.setTeacherName(teacherMsg.getTeacherName());
        tea.setPositionCall(teacherMsg.getPositionCall());
        tea.setSex(teacherMsg.getSex());
        tea.setDeptNo(teacherMsg.getDeptNo());
        Teacher result = dao.updateTeacherByID(tea);
        Dept obj = new Dept();
        obj = (Dept) dao.findByID(obj, teacherMsg.getDeptNo());
        if (result != null) {
            List<TeacherForm> list = new ArrayList<TeacherForm>();
            teacherMsg.setDeptName(obj.getDeptName());
            list.add(teacherMsg);
            return list;
        } else {
            return null;
        }
    }

    @Override
    public boolean delTeacherById(int teacherNo) {
        // 开始删除
        boolean result = dao.delTeacherById(teacherNo);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TeacherForm> queryByTeacherName(String name) {
        List<TeacherForm> list = dao.getTeacherByNameForLike(name);
        return list;
    }

    @Override
    public List<TeachingPlanForm> getTeachingPlanByClassName(TeachingPlanForm tpForm) {
        //调用dao层获取 以className 的信息
        Teaching ting = new Teaching();
        ting.setClassName(tpForm.getClassName());
        List<TeachingPlanForm> list = dao.getTeachingPlanByClassName(ting);
        
        return list;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        // 
        List<Teacher> list=dao.getAllTeacher();
        return list;
    }

    @Override
    public List<Course> getAllCourseByTerm(int termID) {
        // 调用dao层
        List<Course> list = dao.getCourseByTerm(termID);
        return list;
    }
}
