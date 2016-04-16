package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller(value = "guiderAction")
@Scope(value = "prototype")
public class GuiderAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 2914953081752469490L;

    public String exampleMethod() {

        return "pageName";
    }
}
