package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.ScoreForm;
import com.cs.liwei.beans.StuShowGrade;
import com.cs.liwei.beans.StudentDetail;
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
		String hsql = "insert into Score(studentNo,courseNo,examType,pingshiScore,examScore,finalScore"
				+ ",gradePoint) values(?,?,?,?,?,?,?)";
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
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateScore(Score s) {
		// update
		session = getSession();
		String hsql = "update Score s set s.pingshiScore=?,s.examScore=?,s.finalScore=?,s.gradePoint=?"
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
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delScore(Score s) {
		// delete
		session = getSession();
		String hsql = "delete from Score"
				+ "  where studentNo=? and courseNo=?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, s.getStudentNo());
		exe.setParameter(1, s.getCourseNo());
		int num = exe.executeUpdate();
		session.close();
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Student checkUser(Student stu) {

		session = getSession();
		String hsql = "from Student where studentNo=?";
		Query exe = session.createQuery(hsql);
		exe.setParameter(0, stu.getStudentNo());
		// exe.setParameter(1, stu.getStuPass());
		List<?> result = exe.list();
		System.out.println("student:checklogin in :" + result.size());
		session.close();
		if (!result.isEmpty() && result.size() == 1) {
			return (Student) result.get(0);
		}
		return null;
	}

	@Override
	public float getAvgPoint(int studentNo) {
		// 获取平均绩点
		session = getSession();
		String hsql = "select AVG(gradePoint) avgPoint from score where studentNo=? and finalScore>60";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		// exe.setParameter(1, stu.getStuPass());
		List<?> list = exe.list();
		System.out.println("获取平均绩点 :");
		float avgPoint = 0;
		if (null != list && list.size() == 1) {
			if (list.get(0) != null) {
				avgPoint = Float.parseFloat(list.get(0).toString());
			}
		}
		session.close();
		return avgPoint;
	}

	@Override
	public StudentDetail getXueFenCountByCourseType(int studentNo) {
		// 根据courseType 统计学分
		session = getSession();
		String hsql = "select  sum(credit) countXueFen,courseType total from course "
				+ "where courseNo in (select courseNo from score where studentNo=? and finalScore>60)"
				+ "GROUP BY courseType;";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		Iterator<?> it = exe.list().iterator();
		System.out.println("获取分类学分统计 :");
		int totalXueFen = 0;
		int i = 0;
		StudentDetail sd = new StudentDetail();
		while (it.hasNext()) {
			Object[] arr = (Object[]) it.next();
			// 先获取类型 判断后赋值
			String courseType = (String) arr[1];
			System.out.println("courseType：" + courseType);
			totalXueFen = Integer.parseInt(arr[0].toString());
			i++;
			if (courseType.equals("必修课")) {
				sd.setBiXiuXueFen(totalXueFen);
				System.out.println("处理顺序：" + i);
			}
			if (courseType.equals("选修课")) {
				sd.setXuanXiuXueFen(totalXueFen);
				System.out.println("处理顺序：" + i);
			}
			if (courseType.equals("通识教育")) {
				sd.setTongShiXueFen(totalXueFen);
				System.out.println("处理顺序：" + i);
			}
			if (courseType.equals("社会实践")) {
				sd.setSheHuiShiJian(totalXueFen);
				System.out.println("处理顺序：" + i);
			}
		}
		session.close();
		return sd;
	}

	@Override
	public int getHadTotalXueFen(int studentNo) {
		// 统计 已经拥有 且最终成绩 大于60的学分总数
		session = getSession();
		String hsql = "select  sum(credit) totalXueFen from course "
				+ "where courseNo in (select courseNo from score where studentNo=? and finalScore>60)";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		// exe.setParameter(1, stu.getStuPass());
		List<?> list = exe.list();
		System.out.println("获取总学分 :");
		int totalPoint = 0;

		if (null != list && list.size() == 1) {
			if (list.get(0) != null) {
				totalPoint = Integer.parseInt(list.get(0).toString());
			}
		}
		session.close();
		return totalPoint;
	}

	@Override
	public List<Integer> studentOwnTerm(int studentNo) {
		// #已经学了的学期
		session = getSession();
		String hsql = "select  DISTINCT c.term from score s,course c "
				+ "where s.courseNo=c.courseNo AND s.studentNo=? ORDER BY term;";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		// exe.setParameter(1, stu.getStuPass());
		if (exe.list().isEmpty()) {
			return null;
		}
		Iterator<?> it = exe.list().iterator();
		System.out.println("获取拥有的term :");
		session.close();
		List<Integer> list = new ArrayList<Integer>();
		while (it.hasNext()) {
			Object termId = (Object) it.next();
			list.add((Integer) termId);
		}
		System.out.println("list's size is :" + list.size());
		return list;
	}

	@Override
	public List<StuShowGrade> getStuShowGradeByTerm(int studentNo, int term,
			int pageNo) {
		// 获取 以term 分页的 学生 查看页信息
		session = getSession();
		String hsql = "select s.studentNo,s.courseNo,s.finalScore,s.gradePoint,c.credit,st.className,c.courseName,"
				+ " t.teacherNo,tea.teacherName,c.term from score s,student st ,course c,teaching t,teacher tea"
				+ " where  s.studentNo=st.studentNo and s.courseNo=c.courseNo and t.courseNo=c.courseNo  and t.teacherNo=tea.teacherNo"
				+ " and t.className=st.className and  s.studentNo=? and c.term=?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		exe.setParameter(1, term);
		int size = exe.list().size();
		exe.setFirstResult((pageNo - 1) * 8);
		exe.setMaxResults(8);
		if (exe.list().isEmpty()) {
			return null;
		}
		Iterator<?> it = exe.list().iterator();

		System.out.println("获取信息页面 :");
		session.close();
		List<StuShowGrade> list = new ArrayList<StuShowGrade>();
		StuShowGrade ssg = null;
		while (it.hasNext()) {
			Object[] arr = (Object[]) it.next();
			ssg = new StuShowGrade();
			ssg.setStudentNo((int) arr[0]);
			ssg.setCourseNo((int) arr[1]);
			ssg.setFinalScore((int) arr[2]);
			ssg.setGradePoint((float) arr[3]);
			ssg.setCredit((int) arr[4]);
			ssg.setClassName((String) arr[5]);
			ssg.setCourseName((String) arr[6]);
			ssg.setTeacherNo((int) arr[7]);
			ssg.setTeacherName((String) arr[8]);
			ssg.setTerm((int) arr[9]);
			ssg.setPageNum(size);
			list.add(ssg);
		}
		System.out.println("list's size is :" + list.size() + "实际条数：" + size);
		return list;
	}

	@Override
	public List<StuShowGrade> getStuSearchByTermAndCourseName(int studentNo,
			int term, String courseName) {
		// 模糊查询 以term 为单位的课程
		session = getSession();
		String hsql = "select s.studentNo,s.courseNo,s.finalScore,s.gradePoint,c.credit,st.className,c.courseName,"
				+ " t.teacherNo,tea.teacherName,c.term from score s,student st ,course c,teaching t,teacher tea"
				+ " where  s.studentNo=st.studentNo and s.courseNo=c.courseNo and t.courseNo=c.courseNo  and t.teacherNo=tea.teacherNo"
				+ " and t.className=st.className and  s.studentNo=? and c.term=? and c.courseName like ?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, studentNo);
		exe.setParameter(1, term);
		exe.setParameter(2, "%" + courseName + "%");
		int size = exe.list().size();
		// exe.setFirstResult((pageNo-1)*8);
		// exe.setMaxResults(8);
		if (exe.list().isEmpty()) {
			return null;
		}
		Iterator<?> it = exe.list().iterator();

		System.out.println("获取信息页面 :");
		session.close();
		List<StuShowGrade> list = new ArrayList<StuShowGrade>();
		StuShowGrade ssg = null;
		while (it.hasNext()) {
			Object[] arr = (Object[]) it.next();
			ssg = new StuShowGrade();
			ssg.setStudentNo((int) arr[0]);
			ssg.setCourseNo((int) arr[1]);
			ssg.setFinalScore((int) arr[2]);
			ssg.setGradePoint((float) arr[3]);
			ssg.setCredit((int) arr[4]);
			ssg.setClassName((String) arr[5]);
			ssg.setCourseName((String) arr[6]);
			ssg.setTeacherNo((int) arr[7]);
			ssg.setTeacherName((String) arr[8]);
			ssg.setTerm((int) arr[9]);
			ssg.setPageNum(size);
			list.add(ssg);
		}
		System.out.println("模糊查询课程 以term为单位 :" + list.size() + "实际条数：" + size);
		return list;
	}

	@Override
	public boolean changePassword(int studentNo, String password) {
		// update password
		session = getSession();
		String hsql = "update student set stuPass=? where studentNo=?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, password);
		exe.setParameter(1, studentNo);
		int num = exe.executeUpdate();
		session.close();
		if (num == 1) {
			return true;
		}
		return false;
	}
}
