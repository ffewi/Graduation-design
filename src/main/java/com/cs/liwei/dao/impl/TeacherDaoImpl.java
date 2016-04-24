package com.cs.liwei.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.dao.ITeacherDao;
import com.cs.liwei.pojo.Teacher;

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
	public Teacher updateTeacherByID(Teacher tea) {
		session = getSession();
		String hsql = "update Teacher t set t.teacherName=?,t.sex=?,t.positionCall=?, "
				+"t.deptNo=? where t.teacherNo=?";
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
		if (re==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<TeacherForm> getTeacherByNameForLike(String name) {
		session = getSession();
		String hsql = "select t.teacherNo,t.teacherName,t.positionCall,t.sex,t.deptNo,d.deptName "
				+ " from Teacher t,Dept d where t.deptNo=d.deptNo and t.teacherName like ?";
		Query exe = session.createQuery(hsql);
		exe.setParameter(0, "%"+name+"%");
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
}
