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

    public String student() {
        // System.out.println("student log out success!");
        ActionContext.getContext().getSession().remove("student");
        return "stulogin";
    }

    public String admin() {
        // System.out.println("admin log out success!");
        ActionContext.getContext().getSession().remove("admin");
        return "adminlogin";
    }

    public String teacherout() {
        // System.out.println("teacher log out success!");
        ActionContext.getContext().getSession().remove("teacher");
        return "teacherlogin";
    }
}
