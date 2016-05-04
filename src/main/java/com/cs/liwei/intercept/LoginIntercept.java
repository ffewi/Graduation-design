package com.cs.liwei.intercept;

import java.util.Map;

import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Student;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * 类/接口注释 拦截 是否登陆
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class LoginIntercept extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 3306836105174724557L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub

        String msg = invocation.getAction().getClass().getSimpleName();
        // System.out.println(msg);
        if (msg.equals("LoginAction")) {
            return invocation.invoke();
        }

        // 取得请求相关的ActionContext实例
        ActionContext ctx = invocation.getInvocationContext();
        Map<?, ?> session = ctx.getSession();
        Object user = (Object) session.get("admin");
        if (user == null) {
            // System.out.println("没有登录，暂时通过");
            // return invocation.invoke();
            return Action.INPUT;
        }
        if (user instanceof Admin) {
            // System.out.println("这是管理员，大家小心");
        } else if (user instanceof Student) {
            // System.out.println("你只是个学生！");
            if (msg.equals("AdminAction") || msg.equals("AdminMember")
                    || msg.equals("TeacherAction")) {
                // 阻止非管理和操作
                return Action.INPUT;
            }
        } else {
            // System.out.println("老师好！");
            if (msg.equals("AdminAction") || msg.equals("AdminMember")
                    || msg.equals("StudentAction")) {
                // 阻止非管理和操作
                return Action.INPUT;
            }
        }
        // System.out.println(user.toString());
        // 如果没有登陆，或者登陆所有的用户名不是yuewei，都返回重新登陆

        return invocation.invoke();
    }

}
