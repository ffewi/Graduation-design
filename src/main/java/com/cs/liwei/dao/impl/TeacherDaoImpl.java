package com.cs.liwei.dao.impl;

import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.ITeacherDao;
@Repository
public class TeacherDaoImpl extends MySessionFactory implements ITeacherDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理  增删改查  逻辑  获取数据
         */
    }

}
