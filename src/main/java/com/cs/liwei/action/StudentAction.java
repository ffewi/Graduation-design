package com.cs.liwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller(value="stuAction")
@Scope(value="prototype")
public class StudentAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 2698844706433754829L;
    
    
    public String exampleMethod(){
        
        return "pageName";
    }
    
    public String indexPage(){
        System.out.println("comming--------------------studentIndex");
        return "studentIndex";
    }

}
