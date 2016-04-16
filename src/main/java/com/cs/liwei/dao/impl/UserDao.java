package com.cs.liwei.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cs.liwei.beans.UserForm;
import com.cs.liwei.dao.MyBaseDao;
import com.cs.liwei.pojo.User;



public class UserDao implements MyBaseDao {
 
    private SessionFactory sessionFactory;
    
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveObject(Object obj) throws HibernateException {
        // TODO Auto-generated method stub
        sessionFactory.openSession().save(obj);
    }

    @Override
    public User findUser(Object obj) throws HibernateException {
        // TODO Auto-generated method stub
        System.out.println(obj.getClass().getName());
        UserForm userForm = (UserForm)obj;
        String sql="select * from user_t where user_name="+"'"+userForm.getUsername()+"'";
//        SQLQuery s = sessionFactory.openSession().createSQLQuery(sql);
        
        Query result = sessionFactory.openSession().createQuery("from User where user_name="+"'"+userForm.getUsername()+"'");
        //Object s = ssessionFactory.openSession().createQuery(sql);
        List<User> list = result.list();
        System.out.println(list.size());
        //return (User) result;
        Object ss = list.get(0);
        System.out.println(ss.toString());
        return  (User) ss; 
    }


}
