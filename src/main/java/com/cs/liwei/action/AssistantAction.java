package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller(value = "assistantAction")
@Scope(value = "prototype")
public class AssistantAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -1266243953861888378L;

    public String exampleMethod() {

        return "pageName";
    }
}
