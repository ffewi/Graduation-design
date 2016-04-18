package com.cs.liwei.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.UserForm;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.service.AdminManager;
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

    public String invokeUser() {
        ActionContext.getContext().getSession().put("用户名：可以定义一个常量", "getUsername()");
        ActionContext.getContext().getSession().put("用户密码：可以定义一个常量", "getPassword()");
        ActionContext.getContext().getSession().put("用户：可以定义一个常量", "user:我也可以存一个对象");
        return "设置 登陆用户";
        // 记得在struts.xml 中配置 拦截器

    }

    public String execute() {
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

        boolean isLogin = false;
        switch (user.getType()) {
        case UserForm.ADMIN_TYPE:
            Admin admin = new Admin();
            admin.setAccount(Integer.parseInt(user.getUsername()));
            admin.setPassword(user.getPassword());
            isLogin = adminManager.checkLogin(admin);
            if (isLogin) {
                ActionContext.getContext().getSession().put("admin", "getUsername()");
                return "adminHome";
            }
            break;
        case UserForm.TEA_TYPE:
            System.out.println("teacher");
            break;
        case UserForm.STU_TYPE:
            System.out.println("student");
            break;
        case UserForm.ASSIST_TYPE:
            System.out.println("assistant");
            break;
        case UserForm.MISHU_TYPE:
            System.out.println("mishu");
            break;

        default:
            System.out.println("登录类型错误！");
            break;
        }
        return "false";
    }

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    }

}
