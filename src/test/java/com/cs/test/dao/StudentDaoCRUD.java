package com.cs.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.liwei.dao.IBaseDao;
import com.cs.liwei.pojo.Student;

public class StudentDaoCRUD {
    @Resource(name="iBaseDaoImpl")
    private static IBaseDao dao;
    @Test
    public void testSave(){
    }
    @Test
    public void testUpdate(){
    }
    @Test
    public void testDelete(){
    }
    @Test
    public void testFind(){
    }
    @Test
    public void testFindAll(){
        getCx();
        Student t = new Student();
        List<Object> list = dao.findAll(t);
        System.out.println(list.size());
        for (Object object : list) {
            t = (Student) object;
            System.out.println(t);
        }
    }
    
    public static void getCx(){
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        dao=cx.getBean("iBaseDaoImpl", IBaseDao.class);
    }
}
