package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Course;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Profession;

/**
 * 
 * 类/接口注释 DAO层 方法 定义
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public interface IAdminDao extends IBaseDao {
	/*
	 * 增 删 改 查 定义一些其他特殊的操作
	 */
	void searchAllExample();

	/**
	 * 获取dept 所有信息，且分页
	 * 
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	List<Dept> getDeptByPage(int pageNO, int pageSize);

	/**
	 * 获取profession 所有信息，且分页
	 * 
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	List<ProForm> getProByPage(int pageNo, int pageSize);

	/**
	 * 获取course 所有信息，且分页
	 * 
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	List<CourseForm> getCourseByPage(int pageNo, int pageSize);

	/**
	 * 通过传入deptName 的模糊数据查询
	 * 
	 * @param name
	 * @return
	 */
	List<Dept> getDeptByNameForLike(String name);

	/**
	 * 通过传入prefessioniName 的模糊数据查询
	 * 
	 * @param name
	 * @return
	 */
	List<ProForm> getProByNameForLike(String name);

	/**
	 * 通过传入courseName 的模糊数据查询
	 * 
	 * @param name
	 * @return
	 */
	List<CourseForm> getCourseByNameForLike(String name);

	/**
	 * 用户登录检查
	 * 
	 * @param admin
	 * @return
	 */
	boolean checkUser(Admin admin);

	/**
	 * 通过id更新dept信息
	 * 
	 * @param dept
	 * @return
	 */
	Dept updateDeptByID(Dept dept);

	/**
	 * 通过id更新profession信息
	 * 
	 * @param pro
	 * @return
	 */
	Profession updateProByID(Profession pro);

	/**
	 * 通过id更新course信息
	 * 
	 * @param course
	 * @return
	 */
	Course updateCourseByID(Course course);

	/**
	 * 保存professioin 需要传入prefession的全部列选项
	 * 
	 * @param pro
	 * @return
	 */
	boolean savePro(Profession pro);

	/**
	 * 保存course 需要传入course的全部列选项
	 * 
	 * @param course
	 * @return
	 */
	boolean saveCourse(Course course);

	/**
	 * 通过dept主键删除该条信息
	 */
	void delDeptById(int deptNo);

	/**
	 * 通过profession主键删除该条信息
	 */
	void delProById(int professionNo);

	/**
	 * 通过course主键删除该条信息
	 */
	void delCourseById(int courseNo);

	/**
	 * 通过deptNo 统计改院系下面有多少专业
	 * 
	 * @param DeptNo
	 * @return
	 */
	int countProByDeptId(int DeptNo);

	/**
	 * 统计多少专业
	 * 
	 * @return
	 */
	int countPro();

	/**
	 * 统计多少院系
	 * 
	 * @return
	 */
	int countDept();

	/**
	 * 统计多少课程
	 * 
	 * @return
	 */
	int countCourse();

	/**
	 * 通过professionNo 统计该专业下面有多少课程
	 * 
	 * @param professionNo
	 * @return
	 */
	int countCourseByProId(int professionNo);

}
