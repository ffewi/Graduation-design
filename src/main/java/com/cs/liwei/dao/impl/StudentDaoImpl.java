package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.ScoreForm;
import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.dao.IStudentDao;
import com.cs.liwei.pojo.Score;
import com.cs.liwei.pojo.Student;

@Repository
public class StudentDaoImpl extends IBaseDaoImpl implements IStudentDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理 增删改查 逻辑 获取数据
         */
    }

    @Override
    public String getProNameByClassName(String className) {
        String returnMsg = "";
        session = getSession();
        String hsql = "select p.professionName from Student s,ClassTable c,Profession p "
                + " where s.className=c.className and c.professionNo=p.professionNo and s.className=?";
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
        String hsql = "update Student s set s.studentName=? ,s.sex=? ,s.className=? where s.studentNo=? ";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, stu.getStudentName());
        exe.setParameter(1, stu.getSex());
        exe.setParameter(2, stu.getClassName());
        exe.setParameter(3, stu.getStudentNo());
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delStudent(int studentNo) {
        session = getSession();
        String hsql = "delete from Student where studentNo=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, studentNo);
        int num = exe.executeUpdate();
        session.close();
        if (num == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<StudentForm> getStudentByNameForLike(String name) {
        session = getSession();
        String hsql = "select s.studentNo,s.studentName,s.sex,s.className,p.professionName  "
                + " from Student s,ClassTable c,Profession p "
                + " where s.className=c.className and c.professionNo=p.professionNo and s.studentName like ?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, "%" + name + "%");
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

    @Override
    public List<ScoreForm> getScoreMsgIsHaveGrade(int studentNo) {
        // query
        session = getSession();
        String hsql = "select s.courseNo,c.courseName,s.studentNo,s.pingshiScore,s.examScore,s.finalScore,s.gradePoint"
                + " from score s,course c WHERE s.courseNo=c.courseNo and s.studentNo=? ";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, studentNo);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<ScoreForm> list = new ArrayList<ScoreForm>();
        ScoreForm sc = null;
        while (it.hasNext()) {
            sc = new ScoreForm();
            Object[] arr = (Object[]) it.next();
            sc.setCourseNo((int) arr[0]);
            sc.setCourseName((String) arr[1]);
            sc.setStudentNo((int) arr[2]);
            sc.setPingshiScore((int) arr[3]);
            sc.setExamScore((int) arr[4]);
            sc.setFinalScore((int) arr[5]);
            sc.setGradePoint((float) arr[6]);
            list.add(sc);
        }
        return list;
    }

    @Override
    public List<ScoreForm> getIsNotHaveCoureIndex(int studentNo) {
        // select
        session = getSession();
        String hsql = "SELECT t.courseNo,t.courseName from teaching t,student s1"
                + " where s1.className=t.className and s1.studentNo=?"
                + " and t.courseNo not in(select s.courseNo from score s where s.studentNo=?)";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, studentNo);
        exe.setParameter(1, studentNo);
        List<?> result = exe.list();
        session.close();
        Iterator<?> it = result.iterator();
        List<ScoreForm> list = new ArrayList<ScoreForm>();
        ScoreForm sc = null;
        while (it.hasNext()) {
            sc = new ScoreForm();
            Object[] arr = (Object[]) it.next();
            sc.setCourseNo((int) arr[0]);
            sc.setCourseName((String) arr[1]);
            list.add(sc);
        }
        return list;
    }

    @Override
    public boolean addScore(Score s) {
        // addScore
        session = getSession();
        String hsql ="insert into Score(studentNo,courseNo,examType,pingshiScore,examScore,finalScore"
                +",gradePoint) values(?,?,?,?,?,?,?)";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, s.getStudentNo());
        exe.setParameter(1, s.getCourseNo());
        exe.setParameter(2, s.getExamType());
        exe.setParameter(3, s.getPingshiScore());
        exe.setParameter(4, s.getExamScore());
        exe.setParameter(5, s.getFinalScore());
        exe.setParameter(6, s.getGradePoint());
        int num = exe.executeUpdate();
        session.close();
        if (num==1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateScore(Score s) {
        // update
        session = getSession();
        String hsql ="update Score s set s.pingshiScore=?,s.examScore=?,s.finalScore=?,s.gradePoint=?"
                + "  where s.studentNo=? and s.courseNo=?";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, s.getPingshiScore());
        exe.setParameter(1, s.getExamScore());
        exe.setParameter(2, s.getFinalScore());
        exe.setParameter(3, s.getGradePoint());
        exe.setParameter(4, s.getStudentNo());
        exe.setParameter(5, s.getCourseNo());
        int num = exe.executeUpdate();
        session.close();
        if (num==1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean delScore(Score s) {
        // delete
        session = getSession();
        String hsql ="delete from Score"
                + "  where studentNo=? and courseNo=?";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, s.getStudentNo());
        exe.setParameter(1, s.getCourseNo());
        int num = exe.executeUpdate();
        session.close();
        if (num==1) {
            return true;
        }
        return false;
    }
}
