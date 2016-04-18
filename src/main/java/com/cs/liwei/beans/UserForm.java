package com.cs.liwei.beans;

public class UserForm {
    /**
     * admin type 类型 0
     */
    public static final int ADMIN_TYPE = 0; 
    /**
     * teacher type 类型 1
     */
    public static final int TEA_TYPE = 1; 
    /**
     * student type 类型 2
     */
    public static final int STU_TYPE = 2; 
    /**
     * assistant type 类型 3
     */
    public static final int ASSIST_TYPE = 3; 
    /**
     * mishu type 类型 4
     */
    public static final int MISHU_TYPE = 4;
    private String username;
    private String password;
    private int type;
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}
