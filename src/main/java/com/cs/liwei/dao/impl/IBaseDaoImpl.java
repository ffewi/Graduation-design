package com.cs.liwei.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.IBaseDao;
@Repository("iBaseDaoImpl")
public class IBaseDaoImpl extends MySessionFactory implements IBaseDao {
	protected Session session;

	@Override
    public Integer save(Object obj) {
		session = getSession();
        Serializable id = session.save(obj);
        session.close();
        return (Integer) id;
    }

    @Override
    public void delete(Object obj) {
    	session = getSession();
    	Transaction tran = session.beginTransaction();
    	tran.begin();
    	session.delete(obj);
    	tran.commit();
    	session.close();
    }

    @Override
    public Object findByID(Object obj,Serializable id) {
    	session = getSession();
    	Transaction tran = session.beginTransaction();
    	tran.begin();
        Object result = session.get(obj.getClass(), id);
        tran.commit();
        session.close();
        return result;
    }

    @Override
    public void update(Object obj) {
    	session = getSession();
        Transaction tran = session.beginTransaction();
        session.update(obj);
        tran.commit();
        session.close();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAll(Object obj) {
		session = getSession();
		List<?> list =session.createQuery("from "+obj.getClass().getSimpleName()).list();
		session.close();
		return (List<Object>) list;
	}

}
