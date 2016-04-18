package com.cs.liwei.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.IAdminDao;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;

@Repository
public class AdminDaoImpl extends IBaseDaoImpl implements IAdminDao {
    @Override
    public void searchAllExample() {
        /*
         * getSession().处理 增删改查 逻辑 获取数据
         */
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> getDeptByPage(int pageNO, int pageSize) {
        session = getSession();
        String hsql = "from Dept limit ?,?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, (pageNO - 1) * pageSize);
        exe.setParameter(1, pageSize);
        List<?> result = exe.list();
        System.out.println(result.size());
        return (List<Dept>) result;
    }

    @Override
    public boolean checkUser(Admin admin) {
        session = getSession();
        String hsql = "from Admin where account=? and password=?";
        Query exe = session.createQuery(hsql);
        exe.setParameter(0, admin.getAccount());
        exe.setParameter(1, admin.getPassword());
        List<?> result = exe.list();
        System.out.println("admin:checklogin in :" + result.size());
        if (!result.isEmpty() && result.size() == 1) {
            return true;
        }
        return false;
    }

}
