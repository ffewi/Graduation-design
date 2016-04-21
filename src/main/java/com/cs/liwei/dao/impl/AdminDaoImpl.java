package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.dao.IAdminDao;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Profession;

@Repository
public class AdminDaoImpl extends IBaseDaoImpl implements IAdminDao {
    @Override
    public void searchAllExample() {
        /*
         * getSession().处理 增删改查 逻辑 获取数据
         */
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> getDeptByPage(int pageNO, int pageSize) {
        session = getSession();
        String hsql = "from Dept";
        Query exe = session.createQuery(hsql);
        // hsql fen ye
        exe.setFirstResult(((pageNO - 1) * pageSize));
        exe.setMaxResults(pageSize);
        List<?> result = exe.list();
        System.out.println(result.size());
        session.close();
        return (List<Dept>) result;
    }

    @Override
    public boolean checkUser(Admin admin) {
        session = getSession();
        String hsql = "from Admin where account=? and password=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, admin.getAccount());
        exe.setParameter(1, admin.getPassword());
        List<?> result = exe.list();
        System.out.println("admin:checklogin in :" + result.size());
        session.close();
        if (!result.isEmpty() && result.size() == 1) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> getDeptByNameForLike(String name) {
        session = getSession();
        String hsql = "from Dept where deptName like ?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, "%" + name + "%");
        List<?> result = exe.list();
        // System.out.println(result.size());
        session.close();
        return (List<Dept>) result;
    }

    @Override
    public Dept updateDeptByID(Dept dept) {
        session = getSession();
        String hsql = "update Dept d set d.deptName=? where d.deptNo=?";
        // 错误原因 是执行更新。。
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, dept.getDeptName());
        exe.setParameter(1, dept.getDeptNo());
        int num = exe.executeUpdate();
        // System.out.println(result.size());
        session.close();
        if (num == 1) {
            return dept;
        } else {
            return null;
        }
    }

    @Override
    public void delDeptById(int deptNo) {
        session = getSession();
        String hsql = "delete from Dept where deptNo=?";
        // 错误原因 是执行更新。。
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, deptNo);
        exe.executeUpdate();
        session.close();
    }

    @Override
    public List<ProForm> getProByPage(int pageNO, int pageSize) {
        session = getSession();
        String hsql = "select p.professionNo,p.professionName,p.deptNo,d.deptName from Dept d,Profession p where d.deptNo=p.deptNo";
        Query exe = session.createQuery(hsql);
        // hsql fen ye
        exe.setFirstResult(((pageNO - 1) * pageSize));
        exe.setMaxResults(pageSize);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        // System.out.println(result.size());
        List<ProForm> list = new ArrayList<ProForm>();
        ProForm p = null;
        while (it.hasNext()) {
            p = new ProForm();
            Object[] arr = (Object[]) it.next();
            p.setProfessionNo((int) arr[0]);
            p.setProfessionName((String) arr[1]);
            p.setDeptNo((int) arr[2]);
            p.setDeptName((String) arr[3]);
            System.out.println(p.getDeptName() + p.getDeptNo() + p.getProfessionName()
                    + p.getProfessionNo());
            list.add(p);
        }
        return list;
    }

    @Override
    public Profession updateProByID(Profession pro) {
        session = getSession();
        String hsql = "update Profession p set p.deptNo=?,p.professionName=? where p.professionNo=?";
        // 错误原因 是执行更新。。
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, pro.getDeptNo());
        exe.setParameter(1, pro.getProfessionName());
        exe.setParameter(2, pro.getProfessionNo());
        int num = exe.executeUpdate();
        // System.out.println(result.size());
        session.close();
        if (num == 1) {
            return pro;
        } else {
            return null;
        }
    }

    @Override
    public int countProByDeptId(int DeptNo) {
        session = getSession();
        String hsql = "from Profession where deptNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, DeptNo);
        int num = exe.list().size();
        session.close();
        return num;
    }

    @Override
    public boolean savePro(Profession pro) {
        session = getSession();
        String hsql = "insert into Profession (professionNo,professionName,deptNo) values(?,?,?)";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, pro.getProfessionNo());
        exe.setParameter(1, pro.getProfessionName());
        exe.setParameter(2, pro.getDeptNo());
        int re = exe.executeUpdate();
        session.close();
        if (re == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<ProForm> getProByNameForLike(String name) {
        session = getSession();
        String hsql = "select p.professionNo,p.professionName,p.deptNo,d.deptName from Dept d,Profession p where d.deptNo=p.deptNo and p.professionName like ?";
        Query exe = session.createQuery(hsql);
        // 模糊查询
        exe.setParameter(0, "%" + name + "%");
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<ProForm> list = new ArrayList<ProForm>();
        ProForm p = null;
        while (it.hasNext()) {
            p = new ProForm();
            Object[] arr = (Object[]) it.next();
            p.setProfessionNo((int) arr[0]);
            p.setProfessionName((String) arr[1]);
            p.setDeptNo((int) arr[2]);
            p.setDeptName((String) arr[3]);
            list.add(p);
        }
        return list;
    }

    @Override
    public List<CourseForm> getCourseByPage(int pageNo, int pageSize) {
        session = getSession();
        String hsql = "select c.courseNo,c.courseName,c.courseType,c.credit, "
                + "c.term,p.professionName,c.professionNo " + "from Course c,Profession p "
                + "where c.professionNo=p.professionNo ";
        Query exe = session.createQuery(hsql);
        // hsql fen ye
        exe.setFirstResult(((pageNo - 1) * pageSize));
        exe.setMaxResults(pageSize);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<CourseForm> list = new ArrayList<CourseForm>();
        CourseForm c = null;
        while (it.hasNext()) {
            c = new CourseForm();
            Object[] arr = (Object[]) it.next();
            c.setCourseNo((int) arr[0]);
            c.setCourseName((String) arr[1]);
            c.setCourseType((String) arr[2]);
            c.setCredit((int) arr[3]);
            c.setTerm((int) arr[4]);
            c.setProfessionName((String) arr[5]);
            c.setProfessionNo((int) arr[6]);
            list.add(c);
        }
        return list;
    }

}
