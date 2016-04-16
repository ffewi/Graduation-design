package com.cs.test.dao;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.liwei.dao.UserLoginDao;
import com.cs.liwei.pojo.UserLogin;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-hibernate.xml")*/
public class TestUserLoginDao {
    /*@Resource*/
    private UserLoginDao baseDao ;

    @Test
    public void saveObjec(){
     ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
//        baseDao = (UserLogin) cx.getBean("baseDao");
         baseDao=cx.getBean("baseDaoImpl", UserLoginDao.class);
        /*  UserForm f = new UserForm();
        f.setUsername("888888");
        f.setPassword("88888888");
        baseDao.findUser(f);*/
        UserLogin u = new UserLogin();
        u.setLogName("2016004101");
        u.setPassword("password");
        u.setType(2);
        baseDao.saveObject(u);
    }
    @Test
    public void updateObjec(){
     ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        baseDao=cx.getBean("baseDaoImpl", UserLoginDao.class);
        UserLogin u = new UserLogin();
        //u.setId(5);
        u.setLogName("201600410s1");
        u.setPassword("liwei@liwei1");
        u.setType(1);
        baseDao.updateObject(u);
    }
    @Test
    public void deleteObjec(){
     ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        baseDao=cx.getBean("baseDaoImpl", UserLoginDao.class);
        UserLogin u = new UserLogin();
        u.setId(5);
        u.setLogName("2016004101");
        u.setPassword("liwei@liwei1");
        u.setType(1);
        baseDao.delObject(u);
    }
    @Test
    public void searchObjec(){
     ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        baseDao=cx.getBean("baseDaoImpl", UserLoginDao.class);
        UserLogin u = new UserLogin();
        //u.setId(5);
        u.setLogName("2016004101");
        //u.setPassword("1234567");
        //u.setType(2);
        baseDao.searchObject(u);
    }
}
