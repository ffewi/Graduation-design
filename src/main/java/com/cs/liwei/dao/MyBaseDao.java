package com.cs.liwei.dao;


import org.hibernate.HibernateException;

import com.cs.liwei.pojo.User;

public interface MyBaseDao {
    public void saveObject(Object obj) throws HibernateException;  
    public User findUser(Object obj) throws HibernateException; 
}
