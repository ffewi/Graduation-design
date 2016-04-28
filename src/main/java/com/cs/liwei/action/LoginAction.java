package com.cs.liwei.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.StudentDetail;
import com.cs.liwei.beans.UserForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Student;
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
    /*public String invokeUser() {
        ActionContext.getContext().getSession().put("用户名：可以定义一个常量", "getUsername()");
        ActionContext.getContext().getSession().put("用户密码：可以定义一个常量", "getPassword()");
        ActionContext.getContext().getSession().put("用户：可以定义一个常量", "user:我也可以存一个对象");
        return "设置 登陆用户";
        // 记得在struts.xml 中配置 拦截器

    }*/

    public String execute() {
        System.out.println("--------------------------------");
        String returnMsg = INPUT;
        /*
         * 交給spring管理 //this.setUserManager(new UserManagerImpl()); // UserForm re = userManager.loginUser(user); //
         * System.out.println("re"+re==null); // if (re==null) {s // this.addActionMessage("密码或者用户名错误！"); // return INPUT; // } boolean pass
         * =true; //userManager.loginUser(user); if (pass) { System.out.println("success"); if (user.getType()==1) {
         * addActionMessage("teacher!"); }else { addActionMessage("it's a stupid!"); } return SUCCESS; } System.out.println("fail");
         * addActionMessage("密码错误或者权限不够！"); return INPUT;
         */
        if (user != null) {
            System.out.println(user.getType());
        }
        System.out.println("login action-----------------------");
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
            }
            break;
        case UserForm.TEA_TYPE:
            System.out.println("teacher");
            break;
        case UserForm.STU_TYPE:
            System.out.println("student");
            Student stu = new Student();
            stu.setStudentNo(Integer.parseInt(user.getUsername()));
            stu.setStuPass(user.getPassword());
            //验证用户
            Student result = studentManager.checkLogin(stu);
            isLogin =  (result.getStudentNo()==stu.getStudentNo() && result.getStuPass().equals(stu.getStuPass()));
            if (isLogin) {
                stu.setStudentName(result.getStudentName());
                ActionContext.getContext().getSession().put("student", stu);
                sd = studentManager.getStudentTotalCountDetail(stu.getStudentNo());
                /*if (sd==null) {
                    System.out.println("sd == null==================");
                    sd = new StudentDetail();
                }*/
                returnMsg = "studentHome";
            }
            break;
        default:
            System.out.println("登录类型错误！");
            break;
        }
        return returnMsg;
        
    }
    public String loginS(){
        System.out.println("loginS");
        return "studentHome";
    }

    
    //getter and setter
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

}
