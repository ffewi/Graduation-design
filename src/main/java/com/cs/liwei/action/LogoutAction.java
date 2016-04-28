package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value = "logoutAction")
@Scope(value = "prototype")
public class LogoutAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1291710848909775843L;

    public String logoutUser(){
        System.out.println("User log out success!");
        ActionContext.getContext().getSession().remove("student");
        return "login";
    }
}
