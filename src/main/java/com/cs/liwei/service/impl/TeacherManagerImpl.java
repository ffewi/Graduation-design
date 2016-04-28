package com.cs.liwei.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.dao.ITeacherDao;
import com.cs.liwei.pojo.ClassTable;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Profession;
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
        case Method.PAGE_CLASS:
            int totalAssistant = dao.countClass();
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
    public boolean delClassByClassName(String className) {
        // 开始删除
        boolean result = dao.delClassByClassName(className);
        dao.delTeachingByClassName(className);
        if (result) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean delTeachingByCourseNoAndClassName(TeachingPlanForm teaching) {
        // 开始删除
        Teaching t = new Teaching();
        t.setClassName(teaching.getClassName());
        t.setCourseNo(teaching.getCourseNo());
        boolean result = dao.delTeachingByCourseNoAndClassName(t);
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
        // 调用dao层获取 以className 的信息
        Teaching ting = new Teaching();
        ting.setClassName(tpForm.getClassName());
        List<TeachingPlanForm> list = dao.getTeachingPlanByClassName(ting);

        return list;
    }

    @Override
    public List<TeachingPlanForm> getTeachingByNameForLike(TeachingPlanForm tpForm) {
        // 调用dao层获取 以className 的信息
        Teaching ting = new Teaching();
        ting.setClassName(tpForm.getClassName());
        ting.setCourseName(tpForm.getContent());
        List<TeachingPlanForm> list = dao.getTeachingPlanByClassNameForLike(ting);

        return list;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        //
        List<Teacher> list = dao.getAllTeacher();
        return list;
    }

    @Override
    public List<ClassTable> getAllClassName() {
        //
        ClassTable ct = new ClassTable();
        List<Object> list = dao.findAll(ct);
        List<ClassTable> classList = new ArrayList<ClassTable>();
        for (Object object : list) {
            ct = new ClassTable();
            ct = (ClassTable) object;
            classList.add(ct);
        }
        return classList;
    }

    @Override
    public List<Course> getAllCourseByTerm(int termID, String className) {
        // 调用dao层
        List<Course> list = dao.getCourseByTerm(termID, className);
        return list;
    }

    @Override
    public List<TeachingPlanForm> saveTeachingPlan(TeachingPlanForm tpForm) {
        // tpForm传入 参数有 ： className ,courseNo,teacherNo,term(这个字段在Teaching表中无)
        Teaching ti = new Teaching();
        ti.setClassName(tpForm.getClassName());
        ti.setCourseNo(tpForm.getCourseNo());
        ti.setTeacherNo(tpForm.getTeacherNo());
        Course course = new Course();
        course = (Course) dao.findByID(course, tpForm.getCourseNo());
        // 这两个需要查询course表
        ti.setProfessionNo(course.getProfessionNo());
        ti.setCourseName(course.getCourseName());
        // 数据准备好，开始保存到teaching表中
        boolean result = dao.saveTeachingPlan(ti);
        if (result) {
            List<TeachingPlanForm> list = new ArrayList<TeachingPlanForm>();
            tpForm.setCourseName(course.getCourseName());
            Teacher tea = new Teacher();
            tea = (Teacher) dao.findByID(tea, tpForm.getTeacherNo());
            tpForm.setTeacherName(tea.getTeacherName());
            list.add(tpForm);
            return list;
        }
        return null;
    }

    @Override
    public List<TeachingPlanForm> updateTeachingJustChangeTeacher(TeachingPlanForm tpForm) {
        // 页面只传来了 className couresNo teacherNo（要修改为的老师编号）
        Teaching ti = new Teaching();
        ti.setClassName(tpForm.getClassName());
        ti.setCourseNo(tpForm.getCourseNo());
        ti.setTeacherNo(tpForm.getTeacherNo());
        // 执行更新
        boolean isOk = dao.updateTeachingJustChangeTeacher(ti);
        // 数据处理 返回页面
        if (isOk) {
            Course course = new Course();
            course = (Course) dao.findByID(course, tpForm.getCourseNo());
            tpForm.setTerm(course.getTerm());
            tpForm.setCourseName(course.getCourseName());
            Teacher tea = new Teacher();
            tea = (Teacher) dao.findByID(tea, tpForm.getTeacherNo());
            tpForm.setTeacherName(tea.getTeacherName());
            List<TeachingPlanForm> list = new ArrayList<TeachingPlanForm>();
            list.add(tpForm);
            return list;
        }
        return null;
    }

    @Override
    public List<ClassForm> getClassIndexList(int pageNo) {
        // 调用dao层
        List<ClassForm> list = dao.getAllClassListByPage(pageNo);
        return list;
    }

    @Override
    public List<ClassForm> saveClass(ClassForm cfForm) {
        // 调用dao层保存
        ClassTable ct = new ClassTable();
        ct.setClassName(cfForm.getClassName());
        ct.setProfessionNo(cfForm.getProfessionNo());
        ct.setStuTotal(cfForm.getStuTotal());
        int num = dao.countClass();
        Integer className = 2016000+num;
        boolean isHave = dao.hasClassName(className.toString());
        if (isHave) {
            className = 2016000;
            while (isHave) {
                className +=1;
                isHave = dao.hasClassName(className.toString());
            }
        }
//        System.out.println(ct1);
        ct.setClassName(className.toString());
        ct.setAssisantNo(20160101);
        boolean isOk = dao.saveClassByClassNameAndProNoAndstuTotal(ct);
        if (isOk) {
            List<ClassForm> list = new ArrayList<ClassForm>();
            Profession pro = new Profession();
            pro = (Profession) dao.findByID(pro, cfForm.getProfessionNo());
            cfForm.setProfessionName(pro.getProfessionName());
            cfForm.setClassName(className.toString());
            list.add(cfForm);
            return list;
        }
        return null;
    }

	@Override
	public List<ClassForm> exeUpdateClass(ClassForm cfForm) {
		// 调用dao层 更新class
		ClassTable ct = new ClassTable();
        ct.setClassName(cfForm.getClassName());
        ct.setProfessionNo(cfForm.getProfessionNo());
        ct.setStuTotal(cfForm.getStuTotal());
        
        boolean isOk = dao.updateClass(ct);
        if (isOk) {
            List<ClassForm> list = new ArrayList<ClassForm>();
            Profession pro = new Profession();
            pro = (Profession) dao.findByID(pro, cfForm.getProfessionNo());
            cfForm.setProfessionName(pro.getProfessionName());
            list.add(cfForm);
            return list;
        }
        return null;
	}
}
