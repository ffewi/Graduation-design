package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller(value = "adminAction")
@Scope(value = "prototype")
public class AdminAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -7243750676583760197L;

    public String exampleMethod() {

        return "pageName";
    }
}
