package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.pojo.Teacher;

/**
 * 
 * 类/接口注释 DAO层 方法 定义
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public interface ITeacherDao extends IBaseDao {
	/*
	 * 增 删 改 查 定义一些其他特殊的操作
	 */
	void searchAllExample();

	/**
	 * 通过id更新teacher信息
	 * 
	 * @param tea
	 * @return
	 */
	Teacher updateTeacherByID(Teacher tea);

	/**
	 * 获取teacher 信息，且分页
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<TeacherForm> getTeacherByPage(int pageNo, int pageSize);

	/**
	 * 统计多少老师
	 * 
	 * @return
	 */
	int countTeacher();
	/**
	 * 通过teacherNo删除
	 * @param teacherNo
	 */
	boolean delTeacherById(int teacherNo);
	/**
	 * dao层
	 * 模糊查询老师 用过名称
	 * @param name
	 * @return
	 */
	List<TeacherForm> getTeacherByNameForLike(String name);
}
