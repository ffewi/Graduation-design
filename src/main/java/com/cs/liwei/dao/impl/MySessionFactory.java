package com.cs.liwei.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MySessionFactory {

    @Resource
    private SessionFactory sessionFactory;

    public MySessionFactory() {
        super();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}