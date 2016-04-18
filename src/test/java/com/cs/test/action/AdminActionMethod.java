package com.cs.test.action;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.liwei.action.AdminAction;

public class AdminActionMethod {
    // @Resource(name="adminAction")
    private static AdminAction action;

    @Test
    public void testgetAllDeptList() {
//        action.getDeptForm().setPageNo(0);
//        action.getDeptForm().setPageSize(4);
       /* String list = */action.getAllDeptList();
        System.out.println("hello");
    }

    public static void getCx() {
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext(
                "spring-hibernate.xml");
        // dao=cx.getBean("iBaseDaoImpl", IBaseDao.class);
        action = cx.getBean("adminAction", AdminAction.class);
    }
}
