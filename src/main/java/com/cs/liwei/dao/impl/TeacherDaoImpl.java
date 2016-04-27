package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.dao.ITeacherDao;
import com.cs.liwei.pojo.ClassTable;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.pojo.Teaching;

@Repository
public class TeacherDaoImpl extends IBaseDaoImpl implements ITeacherDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理 增删改查 逻辑 获取数据
         */
    }

    @Override
    public List<TeacherForm> getTeacherByPage(int pageNo, int pageSize) {
        session = getSession();
        String hsql = "select t.teacherNo,t.teacherName,t.positionCall,t.sex,t.deptNo,d.deptName "
                + " from Teacher t,Dept d where t.deptNo=d.deptNo";
        Query exe = session.createQuery(hsql);
        // hsql fen ye
        exe.setFirstResult(((pageNo - 1) * pageSize));
        exe.setMaxResults(pageSize);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<TeacherForm> list = new ArrayList<TeacherForm>();
        TeacherForm tea = null;
        while (it.hasNext()) {
            tea = new TeacherForm();
            Object[] arr = (Object[]) it.next();
            tea.setTeacherNo((int) arr[0]);
            tea.setTeacherName((String) arr[1]);
            tea.setPositionCall((String) arr[2]);
            tea.setSex((String) arr[3]);
            tea.setDeptNo((int) arr[4]);
            tea.setDeptName((String) arr[5]);
            list.add(tea);
        }
        return list;
    }

    @Override
    public int countTeacher() {
        session = getSession();
        String hsql = "from Teacher";
        Query exe = session.createQuery(hsql);
        int num = exe.list().size();
        session.close();
        return num;
    }
    @Override
    public int countClass() {
        session = getSession();
        String hsql = "from ClassTable";
        Query exe = session.createQuery(hsql);
        int num = exe.list().size();
        session.close();
        return num;
    }
    @Override
    public Teacher updateTeacherByID(Teacher tea) {
        session = getSession();
        String hsql = "update Teacher t set t.teacherName=?,t.sex=?,t.positionCall=?, "
                + "t.deptNo=? where t.teacherNo=?";
        // 错误原因 是执行更新。。
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, tea.getTeacherName());
        exe.setParameter(1, tea.getSex());
        exe.setParameter(2, tea.getPositionCall());
        exe.setParameter(3, tea.getDeptNo());
        exe.setParameter(4, tea.getTeacherNo());
        System.out.println(tea);
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return tea;
        } else {
            return null;
        }
    }

    @Override
    public boolean delTeacherById(int teacherNo) {
        session = getSession();
        String hsql = "delete from Teacher where teacherNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, teacherNo);
        int re = exe.executeUpdate();
        session.close();
        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean delClassByClassName(String className) {
        session = getSession();
        String hsql = "delete from ClassTable where className=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, className);
        int re = exe.executeUpdate();
        session.close();
        if (re == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<TeacherForm> getTeacherByNameForLike(String name) {
        session = getSession();
        String hsql = "select t.teacherNo,t.teacherName,t.positionCall,t.sex,t.deptNo,d.deptName "
                + " from Teacher t,Dept d where t.deptNo=d.deptNo and t.teacherName like ?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, "%" + name + "%");
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<TeacherForm> list = new ArrayList<TeacherForm>();
        TeacherForm tea = null;
        while (it.hasNext()) {
            tea = new TeacherForm();
            Object[] arr = (Object[]) it.next();
            tea.setTeacherNo((int) arr[0]);
            tea.setTeacherName((String) arr[1]);
            tea.setPositionCall((String) arr[2]);
            tea.setSex((String) arr[3]);
            tea.setDeptNo((int) arr[4]);
            tea.setDeptName((String) arr[5]);
            list.add(tea);
        }
        return list;
    }

    @Override
    public List<TeachingPlanForm> getTeachingPlanByClassName(Teaching ting) {

        session = getSession();
        String hsql = "select t1.courseNo,t1.courseName,t.teacherName,t1.className,t.teacherNo,c.term "
                + " from Teaching t1,Teacher t,Course c where c.courseNo=t1.courseNo and t1.teacherNo=t.teacherNo and t1.className=?"
                + " order by c.term";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, ting.getClassName());
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<TeachingPlanForm> list = new ArrayList<TeachingPlanForm>();
        TeachingPlanForm tp = null;
        while (it.hasNext()) {
            tp = new TeachingPlanForm();
            Object[] arr = (Object[]) it.next();
            tp.setCourseNo((int) arr[0]);
            tp.setCourseName((String) arr[1]);
            tp.setTeacherName((String) arr[2]);
            tp.setClassName((String) arr[3]);
            tp.setTeacherNo((int) arr[4]);
            tp.setTerm((int) arr[5]);
            list.add(tp);
        }
        return list;
    }
    @Override
    public List<TeachingPlanForm> getTeachingPlanByClassNameForLike(Teaching ting) {

        session = getSession();
        String hsql = "select t1.courseNo,t1.courseName,t.teacherName,t1.className,t.teacherNo,c.term "
                + " from Teaching t1,Teacher t,Course c where c.courseNo=t1.courseNo and t1.teacherNo=t.teacherNo and t1.className=?"
                + " and t1.courseName like ?"
                + " order by c.term";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, ting.getClassName());
        exe.setParameter(1, "%"+ting.getCourseName()+"%");
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<TeachingPlanForm> list = new ArrayList<TeachingPlanForm>();
        TeachingPlanForm tp = null;
        while (it.hasNext()) {
            tp = new TeachingPlanForm();
            Object[] arr = (Object[]) it.next();
            tp.setCourseNo((int) arr[0]);
            tp.setCourseName((String) arr[1]);
            tp.setTeacherName((String) arr[2]);
            tp.setClassName((String) arr[3]);
            tp.setTeacherNo((int) arr[4]);
            tp.setTerm((int) arr[5]);
            list.add(tp);
        }
        return list;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Teacher> getAllTeacher() {
        session = getSession();
        String hsql = "from Teacher";
        Query exe = session.createQuery(hsql);
        List<?> result = exe.list();
        session.close();
        return (List<Teacher>) result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Course> getCourseByTerm(int term, String className) {
        session = getSession();
        String hsql = "from Course where term=? and courseNo not in(select courseNo from Teaching where className=?)";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, term);
        exe.setParameter(1, className);
        List<?> result = exe.list();
        session.close();
        // System.out.println("-------------------------------");
        // System.out.println(result);
        // System.out.println("-------------------------------");
        return (List<Course>) result;
    }

    @Override
    public boolean saveTeachingPlan(Teaching tMsg) {
        // save
        session = getSession();
        System.out.println(tMsg);
        String hsql = "insert into Teaching(courseNo,courseName,teacherNo,className,professionNo) "
                + " values(?,?,?,?,?) ";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, tMsg.getCourseNo());
        exe.setParameter(1, tMsg.getCourseName());
        exe.setParameter(2, tMsg.getTeacherNo());
        exe.setParameter(3, tMsg.getClassName());
        exe.setParameter(4, tMsg.getProfessionNo());
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean saveClassByClassNameAndProNoAndstuTotal(ClassTable ct) {
        // save
        session = getSession();
        System.out.println(ct);
        String hsql = "insert into Class(className,professionNo,stuTotal,assisantNo) "
                + " values(?,?,?,?) ";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, ct.getClassName());
        exe.setParameter(1, ct.getProfessionNo());
        exe.setParameter(2, ct.getStuTotal());
        exe.setParameter(3, ct.getAssisantNo());
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean updateTeachingJustChangeTeacher(Teaching tMsg) {
        // update
        session = getSession();
        System.out.println(tMsg);
        String hsql = "update Teaching t set t.teacherNo=? where t.className=? and t.courseNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, tMsg.getTeacherNo());
        exe.setParameter(1, tMsg.getClassName());
        exe.setParameter(2, tMsg.getCourseNo());
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delTeachingByCourseNoAndClassName(Teaching t) {
        // del
        session = getSession();
        String hsql = "delete from Teaching where className=? and courseNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, t.getClassName());
        exe.setParameter(1, t.getCourseNo());
        int re = exe.executeUpdate();
        session.close();
        if (re == 1) {
            return true;
        }
        return false;

    }
    @Override
    public boolean delTeachingByClassName(String className) {
        // del
        session = getSession();
        String hsql = "delete from Teaching where className=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, className);
        exe.executeUpdate();
        session.close();
        return true;
    }
    @Override
    public List<ClassForm> getAllClassListByPage(int pageNo) {
        // search
        session = getSession();
        String hsql = "select c.className,c.professionNo,p.professionName,c.stuTotal"
                +" from ClassTable c,Profession p where c.professionNo=p.professionNo";
        Query exe = session.createQuery(hsql);
        exe.setFirstResult((pageNo-1)*10);
        exe.setMaxResults(10);
        List<?> re = exe.list();
        session.close();
        Iterator<?> it = re.iterator();
        List<ClassForm> list = new ArrayList<ClassForm>();
        ClassForm cf = null;
        while (it.hasNext()) {
            cf =new ClassForm();
            Object[] arr = (Object[]) it.next();
            cf.setClassName((String)arr[0]);
            cf.setProfessionNo((int)arr[1]);
            cf.setProfessionName((String) arr[2]);
            cf.setStuTotal((int)arr[3]);
            list.add(cf);
            //System.out.println(cf.getClassName()+":"+cf.getProfesionName()+":"+cf.getProfessionNo()+":"+cf.getStuTotal());
        }
        //System.out.println(list);
        return list;
    }

    @Override
    public boolean hasClassName(String name) {
        // ishave?
        session = getSession();
        String hsql = "from ClassTable where className=? ";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, name);
        List<?> re = exe.list();
        session.close();
        if (re==null || re.size() != 1) {
            return false;
        }
        return true;
    }
}
