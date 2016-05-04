package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释
 * 
 * 
 * 此处 bean定义为页面与后台交互时数据 存储 的对象载体 teacher 录入，修改成绩页面信息载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年5月2日
 *
 */
public class TeacherAddOrUpdateGrade {

	private int teacherNo;
	private String className;
	private int studentNo;
	private String studentName;
	private int courseNo;
	private String courseName;
	private int pingshiScore;
	private int examScore;

	private int pageNo;
	//查询出来可以修改成绩的总条数
	private int pageNum;
	
	
	
	
	public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public int getPingshiScore() {
		return pingshiScore;
	}

	public void setPingshiScore(int pingshiScore) {
		this.pingshiScore = pingshiScore;
	}

	public int getExamScore() {
		return examScore;
	}

	public void setExamScore(int examScore) {
		this.examScore = examScore;
	}

}
