package com.cs.liwei.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.cs.liwei.pojo.UserLogin;


public interface UserLoginDao {
    
    //zeng
    void saveObject(UserLogin obj) throws HibernateException;
    //shan
    void delObject(UserLogin obj)throws HibernateException;
    //gai
    UserLogin updateObject(UserLogin obj) throws HibernateException;
    //cha
    List<UserLogin> searchObject(UserLogin obj) throws HibernateException;
    
    boolean checkLogin(UserLogin obj) throws HibernateException;
}
