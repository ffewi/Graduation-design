package com.cs.liwei.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.StudentDetail;
import com.cs.liwei.beans.UserForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Student;
import com.cs.liwei.pojo.Teacher;
import com.cs.liwei.service.AdminManager;
import com.cs.liwei.service.StudentManager;
import com.cs.liwei.service.TeacherManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "logAction")
@Scope(value = "prototype")
public class LoginAction extends ActionSupport {

	/**
     * 
     */
	private static final long serialVersionUID = 8008964742702769505L;
	private UserForm user;
	@Resource(name = "adminManagerImpl")
	private AdminManager adminManager;
	@Resource
	private StudentManager studentManager;
	@Resource
	private TeacherManager teacherManager;

	private StudentDetail sd;
	private List<String> classMenuName;
	private Student stuMsg;

	/*
	 * public String invokeUser() {
	 * ActionContext.getContext().getSession().put("用户名：可以定义一个常量",
	 * "getUsername()");
	 * ActionContext.getContext().getSession().put("用户密码：可以定义一个常量",
	 * "getPassword()");
	 * ActionContext.getContext().getSession().put("用户：可以定义一个常量",
	 * "user:我也可以存一个对象"); return "设置 登陆用户"; // 记得在struts.xml 中配置 拦截器
	 * 
	 * }
	 */

	public String execute() {
		String returnMsg = INPUT;
		if (user != null) {
			System.out.println(user.getType());
		}
		// System.out.println("login action-----------------------");
		boolean isLogin = false;
		switch (user.getType()) {
		case UserForm.ADMIN_TYPE:
			Admin admin = new Admin();
			admin.setAccount(Integer.parseInt(user.getUsername()));
			admin.setPassword(user.getPassword());
			isLogin = adminManager.checkLogin(admin);
			if (isLogin) {
				ActionContext.getContext().getSession().put("admin", admin);
				returnMsg = "adminHome";
			} else {
				returnMsg = "adminlogin";
			}
			break;
		case UserForm.TEA_TYPE:
			System.out.println("teacher");
			Teacher t = new Teacher();
			t.setTeacherNo(Integer.parseInt(user.getUsername()));
			t.setTeacherPwd(user.getPassword());
			// 验证用户
			Teacher resultOftea = teacherManager.checkLogin(t);
			if (null != resultOftea) {
				isLogin = resultOftea.getTeacherPwd().equals(t.getTeacherPwd())
						&& resultOftea.getTeacherNo() == t.getTeacherNo();
			}
			if (isLogin) {
				t.setTeacherName(resultOftea.getTeacherName());
				ActionContext.getContext().getSession().put("admin", t);
				//设置老师授课的班级
				classMenuName = teacherManager.getTeachingClassName(t.getTeacherNo());
				System.out.println((classMenuName==null)+"  ---------------------------"+classMenuName.toString());
				returnMsg = "teacherHome";
			}else {
				addActionError("登录失败！");
				returnMsg = "teacherlogin";
			}
			break;
		case UserForm.STU_TYPE:
			System.out.println("student");
			Student stu = new Student();
			stu.setStudentNo(Integer.parseInt(user.getUsername()));
			stu.setStuPass(user.getPassword());
			// 验证用户
			Student result = studentManager.checkLogin(stu);
			if (result != null) {
				isLogin = (result.getStudentNo() == stu.getStudentNo() && result
						.getStuPass().equals(stu.getStuPass()));
			}
			if (isLogin) {
				stu.setStudentName(result.getStudentName());
				ActionContext.getContext().getSession().put("admin", stu);
				sd = studentManager.getStudentTotalCountDetail(stu
						.getStudentNo());
				if (stuMsg == null) {
					stuMsg = new Student();
				}
				stuMsg.setStudentNo(stu.getStudentNo());
				returnMsg = "studentHome";
			} else {
				addActionError("登录失败！");
				returnMsg = "stulogin";
			}
			break;
		default:
			System.out.println("登录类型错误！");
			break;
		}
		return returnMsg;

	}

	public String loginS() {
		System.out.println("loginS");
		return "studentHome";
	}

	// getter and setter
	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
	}

	public StudentDetail getSd() {
		return sd;
	}

	public void setSd(StudentDetail sd) {
		this.sd = sd;
	}

	public Student getStuMsg() {
		return stuMsg;
	}

	public void setStuMsg(Student stuMsg) {
		this.stuMsg = stuMsg;
	}

	public List<String> getClassMenuName() {
		return classMenuName;
	}

	public void setClassMenuName(List<String> classMenuName) {
		this.classMenuName = classMenuName;
	}

	
	

}
