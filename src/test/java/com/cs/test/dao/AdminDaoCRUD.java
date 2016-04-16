package com.cs.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.liwei.dao.IBaseDao;
import com.cs.liwei.pojo.Admin;

public class AdminDaoCRUD {
//    @Resource(name="iBaseDaoImpl")
    private static IBaseDao dao;
    
    @Test
    public void testSave(){
    	getCx();
        Admin obj = new Admin();
//        obj.setAccount(9016005);
        obj.setAccountName("33老大来了");
        obj.setPassword("123456");
        System.out.println(obj.getAccount()+":"+obj.getAccountName()+":"+obj.getPassword());
        System.out.println(dao.save(obj));
    }
    @Test
    public void testUpdate(){
    	getCx();
        Admin obj = new Admin();
        obj.setAccount(9016004);
        obj.setAccountName("是打发第三方！");
        obj.setPassword("789456");
        System.out.println(obj.getAccount()+":"+obj.getAccountName()+":"+obj.getPassword());
        dao.update(obj);
        System.out.println();
    }
    @Test
    public void testDelete(){
    	getCx();
        Admin obj = new Admin();
        obj.setAccount(9016011);
        obj.setAccountName("二老大来了");
        obj.setPassword("123456");
        System.out.println(obj.getAccount()+":"+obj.getAccountName()+":"+obj.getPassword());
        dao.delete(obj);
        System.out.println();
    }
    @Test
    public void testFind(){
    	getCx();
//        Object obj = new Object();
        Admin obj = new Admin();
//        obj.setAccount(9016003);
//        obj.setAccountName("老大来了");
//        obj.setPassword("123456");
        obj=(Admin) dao.findByID(obj, 9016001);
        System.out.println(obj.getAccount()+":"+obj.getAccountName()+":"+obj.getPassword());
    }
    @Test
    public void testFindAll(){
    	getCx();
//        Object obj = new Object();
        Admin obj = new Admin();
//        obj.setAccount(9016003);
//        obj.setAccountName("老大来了");
//        obj.setPassword("123456");
        List<Object> list = dao.findAll(obj);
        System.out.println(list.size());
        for (Object obj2 : list) {
        	Admin obj1 = (Admin) obj2;
        	 System.out.println(obj1.getAccount()+":"+obj1.getAccountName()+":"+obj1.getPassword());
		}
       
    }
    
    public static void getCx(){
    	ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        dao=cx.getBean("iBaseDaoImpl", IBaseDao.class);
    }
}
