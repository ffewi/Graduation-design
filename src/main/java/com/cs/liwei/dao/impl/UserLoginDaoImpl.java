package com.cs.liwei.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.UserLoginDao;
import com.cs.liwei.pojo.UserLogin;
@Repository
public class UserLoginDaoImpl extends MySessionFactory implements UserLoginDao {
    @Override
    public void saveObject(UserLogin obj) throws HibernateException {
        try {
            Serializable re = getSession().save(obj);
            System.out.println(re.toString());
        } catch (Exception e) {
            System.out.println("have exsist");
        }
        System.out.println("saveObject!");
        

    }

    @Override
    public void delObject(UserLogin obj) throws HibernateException {
        Query s = getSession().createQuery("delete from UserLogin where log_name=?");
        s.setParameter(0, obj.getLogName());
        int num=s.executeUpdate();
        System.out.println(num);
    }

    @Override
    public UserLogin updateObject(UserLogin obj) throws HibernateException {
        Transaction t = getSession().beginTransaction();
        Query s = getSession().createQuery("update UserLogin set password='"+obj.getPassword()+"' where log_name= ?");
        s.setParameter(0, obj.getLogName());
        int num = s.executeUpdate();
        t.commit();
        System.out.println("update! :"+num);
        return null;
    }

    @Override
    public List<UserLogin> searchObject(UserLogin obj) throws HibernateException {
        Query re = getSession().createQuery("from UserLogin where log_name=?");
        re.setParameter(0, obj.getLogName());
        @SuppressWarnings("unchecked")
        List<UserLogin> list = re.list();
        System.out.println(list.size()+list.toString());
        return list;
    }

    @Override
    public boolean checkLogin(UserLogin obj) throws HibernateException {
        List<UserLogin> list = searchObject(obj);
        if (list.size()==1) {
            UserLogin result = list.get(0);
            if (result.getLogName().equals(obj.getLogName()) && result.getPassword().equals(obj.getPassword())
                    && result.getType()==obj.getType()) {
                return true;
            }
        }
        return false;
    }

}
