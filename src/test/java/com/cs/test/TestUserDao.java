package com.cs.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.liwei.beans.UserForm;
import com.cs.liwei.dao.impl.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-hibernate.xml")
public class TestUserDao {
   
    private UserDao baseDao ;
    
    @Test
    public void findUser(){
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        baseDao = (UserDao) cx.getBean("baseDao");
        UserForm f = new UserForm();
        f.setUsername("888888");
        f.setPassword("88888888");
        baseDao.findUser(f);
    }
}
