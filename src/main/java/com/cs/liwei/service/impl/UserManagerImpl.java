package com.cs.liwei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.beans.UserForm;
import com.cs.liwei.dao.UserLoginDao;
import com.cs.liwei.pojo.UserLogin;
import com.cs.liwei.service.UserManager;

@Service
public class UserManagerImpl implements UserManager {
    @Resource(name="userLoginDaoImpl")
    private UserLoginDao dao;
    
    @Override
    public void regUser(UserForm userForm) {
        
    }
    @Override
    public boolean loginUser(UserForm user) {
        
        UserLogin ul = new UserLogin();
        ul.setLogName(user.getUsername());
        ul.setPassword(user.getPassword());
        ul.setType(user.getType());
        boolean result = dao.checkLogin(ul);
        if (result) {
            return true;
        }
        return false;
    }
    

}
