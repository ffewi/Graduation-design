package com.cs.liwei.action;


import com.cs.liwei.beans.UserForm;
import com.cs.liwei.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private static final long serialVersionUID = 1L;  
    
    private UserForm user;  
  
    private UserManager userManager;
    
    
    
    

    public String execute() {  
        try { 
            /*交給spring管理*/
            //this.setUserManager(new UserManagerImpl());  
            userManager.regUser(user);  
            System.out.println("register!");
            return SUCCESS;  
  
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
    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
