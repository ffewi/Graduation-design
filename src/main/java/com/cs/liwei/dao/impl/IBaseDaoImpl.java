package com.cs.liwei.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.cs.liwei.dao.IBaseDao;
@Repository("iBaseDaoImpl")
public class IBaseDaoImpl extends MySessionFactory implements IBaseDao {
	private Session session;

	@Override
    public Integer save(Object obj) {
		session = getSession();
        Serializable id = session.save(obj);
        return (Integer) id;
    }

    @Override
    public void delete(Object obj) {
    	session = getSession();
    	Transaction tran = session.beginTransaction();
    	tran.begin();
    	session.delete(obj);
    	tran.commit();
    }

    @Override
    public Object findByID(Object obj,Serializable id) {
    	session = getSession();
    	Transaction tran = session.beginTransaction();
    	tran.begin();
        Object result = session.get(obj.getClass(), id);
        tran.commit();
        return result;
    }

    @Override
    public void update(Object obj) {
    	session = getSession();
        Transaction tran = session.beginTransaction();
        session.update(obj);
        tran.commit();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findAll(Object obj) {
		session = getSession();
		List<?> list =session.createQuery("from "+obj.getClass().getSimpleName()).list();
		return (List<Object>) list;
	}

}
