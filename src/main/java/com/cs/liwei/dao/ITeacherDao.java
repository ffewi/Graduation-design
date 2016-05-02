package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.beans.ClassForm;
import com.cs.liwei.beans.TeacherAddOrUpdateGrade;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.beans.TeachingPlanForm;
import com.cs.liwei.pojo.ClassTable;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Score;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.pojo.Teaching;

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
	 * 统计多少班级
	 * 
	 * @return
	 */
	int countClass();

	/**
	 * 通过teacherNo删除
	 * 
	 * @param teacherNo
	 */
	boolean delTeacherById(int teacherNo);

	/**
	 * 通过className删除
	 * 
	 * @param className
	 */
	boolean delClassByClassName(String className);

	/**
	 * 通过 className courseNo 删除
	 * 
	 * @param t
	 * @return
	 */
	boolean delTeachingByCourseNoAndClassName(Teaching t);

	/**
	 * 通过 className 删除
	 * 
	 * @param t
	 * @return
	 */
	boolean delTeachingByClassName(String className);

	/**
	 * dao层 模糊查询老师 用过名称
	 * 
	 * @param name
	 * @return
	 */
	List<TeacherForm> getTeacherByNameForLike(String name);

	/**
	 * 获取以班级号为单位的教学制定计划
	 * 
	 * @param ting
	 * @return
	 */
	List<TeachingPlanForm> getTeachingPlanByClassName(Teaching ting);

	/**
	 * 根据courseName className分类模糊查询
	 * 
	 * @param ting
	 * @return
	 */
	List<TeachingPlanForm> getTeachingPlanByClassNameForLike(Teaching ting);

	/**
	 * 获取所有老师
	 * 
	 * @return
	 */
	List<Teacher> getAllTeacher();

	/**
	 * 获取term 下的课程 并且赛选班级已经选了的课程
	 * 
	 * @param term
	 *            className
	 * @return
	 */
	List<Course> getCourseByTerm(int term, String className);

	/**
	 * 保存teaching 需要传入5个字段值，
	 * courseNo，courseName,professionNo,className,teacherNo
	 * 
	 * @param tMsg
	 * @return
	 */
	boolean saveTeachingPlan(Teaching tMsg);

	/**
	 * 仅仅更新上课教师
	 * 
	 * @param tMsg
	 * @return
	 */
	boolean updateTeachingJustChangeTeacher(Teaching tMsg);

	/**
	 * dao 层封装好classForm 传递到页面
	 * 
	 * @param pageNo
	 * @return
	 */
	List<ClassForm> getAllClassListByPage(int pageNo);

	/**
	 * 保存 class 数据有 className,prefessionNo,stuTotal
	 * 
	 * @param ct
	 * @return
	 */
	boolean saveClassByClassNameAndProNoAndstuTotal(ClassTable ct);

	/**
	 * 有无className
	 * 
	 * @param name
	 * @return
	 */
	boolean hasClassName(String name);

	/**
	 * 更新class
	 * 
	 * @param ct
	 * @return
	 */
	boolean updateClass(ClassTable ct);

	/**
	 * 更新密码
	 * 
	 * @param teacherNo
	 * @param pass
	 * @return
	 */
	boolean changePass(int teacherNo, String pass);

	/**
	 * 通过教师编号获取所教的班级有哪些
	 * 
	 * @param teacherNo
	 * @return
	 */
	List<String> getTeachingClassNameByTeacherNo(int teacherNo);

	/**
	 * dao 层 获取教师所选班级下的 自己所教的课程
	 * 
	 * @param tau
	 * @return
	 */
	List<TeacherAddOrUpdateGrade> getCourseMenuByTeacherNoAndClassName(
			TeacherAddOrUpdateGrade tau);

	/**
	 * 获取老师可以录入的学生 及其课程号
	 * 
	 * @param teacherNo
	 * @param courseNo
	 * @param className
	 * @param pageNo
	 * @return
	 */
	List<TeacherAddOrUpdateGrade> getStudentLuru(int teacherNo, int courseNo,
			String className, int pageNo);
	/**
	 * 录入加工后的成绩
	 * @param s
	 */
	void insertStudentScoreByTeacherNo(Score s);
}
