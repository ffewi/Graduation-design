package com.cs.liwei.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.Method;
import com.cs.liwei.beans.Page;
import com.cs.liwei.beans.TeacherForm;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.service.AdminManager;
import com.cs.liwei.service.StudentManager;
import com.cs.liwei.service.TeacherManager;
import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "adminMember")
@Scope(value = "prototype")
public class AdminMember extends ActionSupport {
	@Resource
	private TeacherManager teacher;
	@Resource
	private StudentManager student;
	@Resource
	private AdminManager admin;

	// 页面内容存值
	private List<TeacherForm> teaList;
	private List<Dept> list;
	private TeacherForm teacherForm;
	private Page pageMsg;
	private Method msg;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5512566885571007850L;

	public String exampleMethod() {
		System.out.println("这是个测试");
		return "adminMember";
	}

	// 修改页面跳转
	public String update() {
		String returnMsg = "";
		switch (msg.getMethod()) {
		case 1:
			// 老师修改也跳转
			list = admin.getAllDept();
			returnMsg = "teacherUpdate";
			break;
		default:
			break;
		}
		return returnMsg;
	}

	public String add() {
		String returnMsg = "";
		switch (msg.getMethod()) {
		case Method.ADD_TEACHER:
			list = admin.getAllDept();
			returnMsg = "teacherAdd";
			break;

		default:
			break;
		}

		return returnMsg;
	}

	// 执行更新操作 teacher
	public String exeUpdateTeacher() {

		System.out.println("teacherUpdate!");
		teaList = teacher.updateDeptByID(teacherForm);
		if (pageMsg == null) {
			pageMsg = new Page();
		}
		pageMsg.setPageNo(1);
		pageMsg.setPageCount(1);
		return "teacherIndex";
	}

	// 获取老师默认页面
	public String getAllTeacherList() {
		System.out.println("adminMember");
		teaList = teacher.getAllTeacherList(pageMsg.getPageNo(), 10);
		System.out.println(teaList.size());
		pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_TEACHER));
		return "teacherIndex";
	}

	// 添加老师
	public String addTeacher() {
		// System.out.println(teacherForm.getTeacherName()+":"+teacherForm.getPositionCall()+":"
		// +"deptNO:"+teacherForm.getDeptNo()+":"+teacherForm.getSex());
		teaList = teacher.addTeacher(teacherForm);
		list = admin.getAllDept();
		if (pageMsg == null) {
			pageMsg = new Page();
		}
		pageMsg.setPageNo(1);
		pageMsg.setPageCount(1);
		return "teacherIndex";
	}

	// 删除 teacher
	public String delTeacherById() {
		System.out.println(teacherForm.getTeacherNo() + "===================");
		boolean result = teacher.delTeacherById(teacherForm.getTeacherNo());
		if (result) {
			teaList = teacher.getAllTeacherList(pageMsg.getPageNo(), 10);
			pageMsg.setPageCount(teacher.getPageTotal(Method.PAGE_TEACHER));
			return "teacherIndex";
		} else {
			return "执行错误的页面！";
		}

	}

	// 模糊查询老师姓名
	public String searchTeacherByNameForLike() {
		teaList = teacher.queryByTeacherName(teacherForm.getContent());
		if (pageMsg == null) {
			pageMsg = new Page();
		}
		if (teaList == null || teaList.size()==0 ) {
			pageMsg.setPageNo(0);
			pageMsg.setPageCount(0);
		} else {
			pageMsg.setPageNo(1);
			pageMsg.setPageCount(1);
		}
		list = admin.getAllDept();
		return "teacherIndex";
	}

	// getter and setter method

	public Page getPageMsg() {
		return pageMsg;
	}

	public List<TeacherForm> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<TeacherForm> teaList) {
		this.teaList = teaList;
	}

	public void setPageMsg(Page pageMsg) {
		this.pageMsg = pageMsg;
	}

	public Method getMsg() {
		return msg;
	}

	public void setMsg(Method msg) {
		this.msg = msg;
	}

	public List<Dept> getList() {
		return list;
	}

	public void setList(List<Dept> list) {
		this.list = list;
	}

	public TeacherForm getTeacherForm() {
		return teacherForm;
	}

	public void setTeacherForm(TeacherForm teacherForm) {
		this.teacherForm = teacherForm;
	}

}
