package com.cs.liwei.dao.impl;

import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.ICourseDao;
@Repository
public class CourseDaoImpl extends MySessionFactory implements ICourseDao {

    @Override
    public void searchAllExample() {
        // TODO Auto-generated method stub
        /*
         * getSession().处理  增删改查  逻辑  获取数据
         */
    }

}
