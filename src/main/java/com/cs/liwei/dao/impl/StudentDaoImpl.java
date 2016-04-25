package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.dao.IStudentDao;
import com.cs.liwei.pojo.Student;
@Repository
public class StudentDaoImpl extends IBaseDaoImpl implements IStudentDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理  增删改查  逻辑  获取数据
         */
    }

    @Override
    public String getProNameByClassName(String className) {
        String returnMsg = "";
        session = getSession();
        String hsql= "select p.professionName from Student s,ClassTable c,Profession p "
                +" where s.className=c.className and c.professionNo=p.professionNo and s.className=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, className);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        while (it.hasNext()) {
            returnMsg = (String) it.next();
        }
        return returnMsg;
    }

    @Override
    public boolean updateStudent(Student stu) {
        session = getSession();
        String hsql= "update Student s set s.studentName=? ,s.sex=? ,s.className=? where s.studentNo=? ";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, stu.getStudentName());
        exe.setParameter(1, stu.getSex());
        exe.setParameter(2, stu.getClassName());
        exe.setParameter(3, stu.getStudentNo());
        int num = exe.executeUpdate();
        session.close();
        if (num==1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delStudent(int studentNo) {
        session = getSession();
        String hsql= "delete from Student where studentNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, studentNo);
        int num = exe.executeUpdate();
        session.close();
        if (num==1) {
            return true;
        }
        return false;
    }

    @Override
    public List<StudentForm> getStudentByNameForLike(String name) {
        session = getSession();
        String hsql = "select s.studentNo,s.studentName,s.sex,s.className,p.professionName  "
                + " from Student s,ClassTable c,Profession p "
                +" where s.className=c.className and c.professionNo=p.professionNo and s.studentName like ?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, "%"+name+"%");
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<StudentForm> list = new ArrayList<StudentForm>();
        StudentForm stu = null;
        while (it.hasNext()) {
            stu = new StudentForm();
            Object[] arr = (Object[]) it.next();
            stu.setStudentNo((int) arr[0]);
            stu.setStudentName((String) arr[1]);
            stu.setSex((String) arr[2]);
            stu.setClassName((String) arr[3]);
            stu.setProfessionName((String) arr[4]);
            list.add(stu);
        }
        return list;
    }

}
