package com.cs.liwei.intercept;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 
 * 类/接口注释
 * 拦截 是否登陆
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class LoginIntercept extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        
        
        
        
     // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get("user_name");  
  
        // 如果没有登陆，或者登陆所有的用户名不是yuewei，都返回重新登陆  
  
        if (user != null && user.equals("yuewei")) {  
            System.out.println("test");  
            return invocation.invoke();  
        }  
  
        ctx.put("tip", "你还没有登录");  
        return Action.LOGIN;
        
        
        
        
        //return null;
    }

}
