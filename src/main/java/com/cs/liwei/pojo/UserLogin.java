package com.cs.liwei.pojo;

import java.io.Serializable;

public class UserLogin implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String logName;
    private String password;
    
    /**
     *0:Admin 1:T 2:S 
     */
    private int type;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogName() {
        return logName;
    }
    public void setLogName(String logName) {
        this.logName = logName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return id+" "+logName+" "+password+":"+type;
    }
    
}
