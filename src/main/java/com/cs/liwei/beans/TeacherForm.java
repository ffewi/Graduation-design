package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释
 * 
 * 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月21日
 *
 */
public class TeacherForm {
	/*
	 * 对应前台表单 传来的属性名字
	 */
	private int teacherNo;
	private String teacherName;
	private String positionCall;
	private String sex;
	private int deptNo;
	private String deptName;
	// 模糊查询内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getPositionCall() {
		return positionCall;
	}

	public void setPositionCall(String positionCall) {
		this.positionCall = positionCall;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
