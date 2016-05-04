package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.TeacherAddOrUpdateGrade;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.dao.ITeacherDao;
import com.cs.liwei.pojo.ClassTable;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Score;
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
	public List<TeachingPlanForm> getTeachingPlanByClassNameForLike(
			Teaching ting) {

		session = getSession();
		String hsql = "select t1.courseNo,t1.courseName,t.teacherName,t1.className,t.teacherNo,c.term "
				+ " from Teaching t1,Teacher t,Course c where c.courseNo=t1.courseNo and t1.teacherNo=t.teacherNo and t1.className=?"
				+ " and t1.courseName like ?" + " order by c.term";
		Query exe = session.createQuery(hsql);
		exe.setParameter(0, ting.getClassName());
		exe.setParameter(1, "%" + ting.getCourseName() + "%");
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
				+ " from ClassTable c,Profession p where c.professionNo=p.professionNo";
		Query exe = session.createQuery(hsql);
		exe.setFirstResult((pageNo - 1) * 10);
		exe.setMaxResults(10);
		List<?> re = exe.list();
		session.close();
		Iterator<?> it = re.iterator();
		List<ClassForm> list = new ArrayList<ClassForm>();
		ClassForm cf = null;
		while (it.hasNext()) {
			cf = new ClassForm();
			Object[] arr = (Object[]) it.next();
			cf.setClassName((String) arr[0]);
			cf.setProfessionNo((int) arr[1]);
			cf.setProfessionName((String) arr[2]);
			cf.setStuTotal((int) arr[3]);
			list.add(cf);
			// System.out.println(cf.getClassName()+":"+cf.getProfesionName()+":"+cf.getProfessionNo()+":"+cf.getStuTotal());
		}
		// System.out.println(list);
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
		if (re == null || re.size() != 1) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateClass(ClassTable ct) {
		// update
		session = getSession();
		String hsql = "update ClassTable c set c.professionNo=?,c.stuTotal=? where c.className=? ";
		Query exe = session.createQuery(hsql);
		exe.setParameter(0, ct.getProfessionNo());
		exe.setParameter(1, ct.getStuTotal());
		exe.setParameter(2, ct.getClassName());
		int num = exe.executeUpdate();
		session.close();
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changePass(int teacherNo, String pass) {
		// update
		session = getSession();
		String hsql = "update Teacher t set t.teacherPwd=? where t.teacherNo=? ";
		Query exe = session.createQuery(hsql);
		exe.setParameter(0, pass);
		exe.setParameter(1, teacherNo);
		int num = exe.executeUpdate();
		session.close();
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> getTeachingClassNameByTeacherNo(int teacherNo) {
		// search
		session = getSession();
		String hsql = "select DISTINCT t.className from teaching t where teacherNo=?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, teacherNo);
		List<?> list = exe.list();
		session.close();
		if (list != null && !list.isEmpty()) {
			List<String> clist = new ArrayList<String>();
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				Object cName = (Object) it.next();
				clist.add((String) cName);
			}
			/*
			 * System.out.println(clist.size()); if (clist.size()>0) {
			 * System.out.println(clist.get(0).toString()); }
			 */
			return clist;
		}
		return null;
	}

	@Override
	public List<TeacherAddOrUpdateGrade> getCourseMenuByTeacherNoAndClassName(
			TeacherAddOrUpdateGrade tau) {
		// search
		session = getSession();
		String hsql = "select t.courseNo,t.courseName from teaching  t"
				+ " where teacherNo=? and className=?";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, tau.getTeacherNo());
		exe.setParameter(1, tau.getClassName());
		List<?> list = exe.list();
		session.close();
		if (list != null && !list.isEmpty()) {
			List<TeacherAddOrUpdateGrade> clist = new ArrayList<TeacherAddOrUpdateGrade>();
			TeacherAddOrUpdateGrade tauContent = null;
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				Object[] tauMsg = (Object[]) it.next();
				tauContent = new TeacherAddOrUpdateGrade();
				tauContent.setCourseNo((int) tauMsg[0]);
				tauContent.setCourseName((String) tauMsg[1]);
				clist.add(tauContent);
			}
			/*
			 * System.out.println(clist.size()); if (clist.size()>0) {
			 * System.out.println(clist.get(0).toString()); }
			 */
			return clist;
		}
		return null;
	}

	@Override
	public List<TeacherAddOrUpdateGrade> getStudentLuru(int teacherNo,
			int courseNo, String className, int pageNo) {
		// 查询教师可以录入的学生
		session = getSession();
		String hsql = "select tt.*,sc.finalScore from (select t.courseNo,t.courseName,s.studentNo,s.studentName from teaching  t,student s"
				+ " where s.className=t.className and teacherNo=? and t.className=?"
				+ " and courseNo=?) tt LEFT JOIN score sc "
				+ " on tt.courseNo=sc.courseNo and tt.studentNo=sc.studentNo"
				+ " where sc.finalScore IS Null";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, teacherNo);
		exe.setParameter(1, className);
		exe.setParameter(2, courseNo);
		List<?> list = exe.list();
		session.close();
		if (list != null && !list.isEmpty()) {
			List<TeacherAddOrUpdateGrade> clist = new ArrayList<TeacherAddOrUpdateGrade>();
			TeacherAddOrUpdateGrade tauContent = null;
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				Object[] tauMsg = (Object[]) it.next();
				tauContent = new TeacherAddOrUpdateGrade();
				tauContent.setCourseNo((int) tauMsg[0]);
				tauContent.setCourseName((String) tauMsg[1]);
				tauContent.setStudentNo((int) tauMsg[2]);
				tauContent.setStudentName((String) tauMsg[3]);
				clist.add(tauContent);
			}
			/*
			 * System.out.println(clist.size()); if (clist.size()>0) {
			 * System.out.println(clist.get(0).toString()); }
			 */
			return clist;
		}
		return null;
	}
	@Override
    public List<TeacherAddOrUpdateGrade> getStudentXiugai(int teacherNo,
            int courseNo, String className, int pageNo) {
        // 查询教师可以录入的学生
        session = getSession();
        String hsql = "select tt.*,sc.pingshiScore,sc.examScore,sc.finalScore from (select t.courseNo,t.courseName,s.studentNo,s.studentName from teaching  t,student s"
                + " where s.className=t.className and teacherNo=? and t.className=?"
                + " and courseNo=?) tt LEFT JOIN score sc "
                + " on tt.courseNo=sc.courseNo and tt.studentNo=sc.studentNo"
                + " where sc.finalScore IS not Null";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, teacherNo);
        exe.setParameter(1, className);
        exe.setParameter(2, courseNo);
        List<?> list = exe.list();
        int totalSize = 0;
        if (null!=list) {
            totalSize = list.size();
        }
        exe.setFirstResult((pageNo-1)*8);
        exe.setMaxResults(8);
        list = exe.list();
        session.close();
        if (list != null && !list.isEmpty()) {
            List<TeacherAddOrUpdateGrade> clist = new ArrayList<TeacherAddOrUpdateGrade>();
            TeacherAddOrUpdateGrade tauContent = null;
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                Object[] tauMsg = (Object[]) it.next();
                tauContent = new TeacherAddOrUpdateGrade();
                tauContent.setCourseNo((int) tauMsg[0]);
                tauContent.setCourseName((String) tauMsg[1]);
                tauContent.setStudentNo((int) tauMsg[2]);
                tauContent.setStudentName((String) tauMsg[3]);
                tauContent.setPingshiScore((int) tauMsg[4]);
                tauContent.setExamScore((int) tauMsg[5]);
                tauContent.setPageNum(totalSize);
                clist.add(tauContent);
            }
            /*
             * System.out.println(clist.size()); if (clist.size()>0) {
             * System.out.println(clist.get(0).toString()); }
             */
            return clist;
        }
        return null;
    }
    @Override
    public List<TeacherAddOrUpdateGrade> getStudentSeacherByStuName(int teacherNo,
            int courseNo, String className, String studentName) {
        // 查询教师可以录入的学生
        session = getSession();
        String hsql = "select tt.*,sc.pingshiScore,sc.examScore,sc.finalScore from (select t.courseNo,t.courseName,s.studentNo,s.studentName from teaching  t,student s"
                + " where s.className=t.className and teacherNo=? and t.className=?"
                + " and courseNo=?) tt LEFT JOIN score sc "
                + " on tt.courseNo=sc.courseNo and tt.studentNo=sc.studentNo"
                + " where sc.finalScore IS not Null and tt.studentName like ?";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, teacherNo);
        exe.setParameter(1, className);
        exe.setParameter(2, courseNo);
        exe.setParameter(3, "%"+studentName+"%");
        List<?> list = exe.list();
        int totalSize = 0;
        if (null!=list) {
            totalSize = list.size();
        }
        session.close();
        if (list != null && !list.isEmpty()) {
            List<TeacherAddOrUpdateGrade> clist = new ArrayList<TeacherAddOrUpdateGrade>();
            TeacherAddOrUpdateGrade tauContent = null;
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                Object[] tauMsg = (Object[]) it.next();
                tauContent = new TeacherAddOrUpdateGrade();
                tauContent.setCourseNo((int) tauMsg[0]);
                tauContent.setCourseName((String) tauMsg[1]);
                tauContent.setStudentNo((int) tauMsg[2]);
                tauContent.setStudentName((String) tauMsg[3]);
                tauContent.setPingshiScore((int) tauMsg[4]);
                tauContent.setExamScore((int) tauMsg[5]);
                tauContent.setPageNum(totalSize);
                clist.add(tauContent);
            }
            /*
             * System.out.println(clist.size()); if (clist.size()>0) {
             * System.out.println(clist.get(0).toString()); }
             */
            return clist;
        }
        return null;
    }
	@Override
	public void insertStudentScoreByTeacherNo(Score s) {
		// insert
		session = getSession();
		String hsql ="insert into score(studentNo,courseNo,examType,pingshiScore,examScore,finalScore,gradePoint) values(?,?,?,?,?,?,?)";
		Query exe = session.createSQLQuery(hsql);
		exe.setParameter(0, s.getStudentNo());
		exe.setParameter(1, s.getCourseNo());
		exe.setParameter(2, s.getExamType());
		exe.setParameter(3, s.getPingshiScore());
		exe.setParameter(4, s.getExamScore());
		exe.setParameter(5, s.getFinalScore());
		exe.setParameter(6, s.getGradePoint());
		exe.executeUpdate();
		session.close();
	}
	@Override
    public void updateStudentScoreByTeacherNo(Score s) {
        // insert
        session = getSession();
        String hsql ="update score set pingshiScore=?,examScore=?,finalScore=?,gradePoint=? where studentNo=? and courseNo=?";
        Query exe = session.createSQLQuery(hsql);
        exe.setParameter(0, s.getPingshiScore());
        exe.setParameter(1, s.getExamScore());
        exe.setParameter(2, s.getFinalScore());
        exe.setParameter(3, s.getGradePoint());
        exe.setParameter(4, s.getStudentNo());
        exe.setParameter(5, s.getCourseNo());
        exe.executeUpdate();
        session.close();
    }
}
