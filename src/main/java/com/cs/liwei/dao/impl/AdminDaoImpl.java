package com.cs.liwei.dao.impl;

import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.IAdminDao;
@Repository
public class AdminDaoImpl extends MySessionFactory implements IAdminDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理  增删改查  逻辑  获取数据
         */
    }

}
