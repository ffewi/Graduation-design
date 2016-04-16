package com.cs.liwei.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.UserForm;
import com.cs.liwei.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value="logAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;  
    
    private UserForm user;  
    @Resource(name="userManagerImpl")
    private UserManager userManager;
    
    public String invokeUser() {
        ActionContext.getContext().getSession().put("用户名：可以定义一个常量","getUsername()");  
        ActionContext.getContext().getSession().put("用户密码：可以定义一个常量","getPassword()");
        ActionContext.getContext().getSession().put("用户：可以定义一个常量","user:我也可以存一个对象");
        return "设置 登陆用户";
        //记得在struts.xml 中配置 拦截器
        
    }
    
    

    public String execute() {  
        try { 
            /*交給spring管理*/
            //this.setUserManager(new UserManagerImpl());  
//            UserForm re = userManager.loginUser(user);  
//            System.out.println("re"+re==null);
//            if (re==null) {s
//               this.addActionMessage("密码或者用户名错误！");
//                return INPUT;
//            }
            boolean pass = userManager.loginUser(user);
            if (pass) {
                System.out.println("success");
                if (user.getType()==1) {
                    addActionMessage("teacher!");
                }else {
                    addActionMessage("it's a stupid!");
                }
                return SUCCESS;
            }
            System.out.println("fail");
            addActionMessage("密码错误或者权限不够！");
            return INPUT;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }

    public UserForm getUser() {
        return user;
    }

    public void setUser(UserForm user) {
        this.user = user;
    } 

}
