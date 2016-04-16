package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "teaAction")
@Scope(value = "prototype")
public class TeacherAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 8976661912458589520L;

    public String exampleMethod() {

        return "pageName";
    }
}
