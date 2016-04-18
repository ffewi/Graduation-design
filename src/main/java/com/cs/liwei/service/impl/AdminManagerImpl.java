package com.cs.liwei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.dao.IAdminDao;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.service.AdminManager;
@Service
public class AdminManagerImpl implements AdminManager {
    /**
     * 注入 dao
     * @resource  daoName
     * private dao
     */
    @Resource(name="adminDaoImpl")
    private IAdminDao dao;
    @Override
    public void example() {
        /*
         * 一些逻辑方法，并调用dao层 进行数据分析
         */
    }

    @Override
    public List<Dept> getAllByPage(int pageNo, int pageSize) {
        List<Dept> list = dao.getDeptByPage(pageNo, pageSize);
        return list;
    }

    @Override
    public boolean checkLogin(Admin admin) {
        boolean msg = dao.checkUser(admin);
        if (msg) {
            return true;
        }
        return false;
    }

}
