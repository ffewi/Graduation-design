package com.cs.liwei.service;

import com.cs.liwei.beans.UserForm;



public interface UserManager {
    
    void regUser(UserForm user);
    
    boolean loginUser(UserForm user);
}
