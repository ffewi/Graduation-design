package com.cs.liwei.pojo;

import java.io.Serializable;
/**
 * 
 * 类/接口注释
 * 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class Admin implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 323880662153297007L;
    /*
     * some propertype  属性
     */
    /**
     * 管理员账户
     */
    private Integer account;
    /**
     * 管理员密码
     */
    private String password;
    /**
     * 管理员名称
     */
    private String accountName;
    /**
     * @return the account
     */
    public Integer getAccount() {
        return account;
    }
    /**
     * @param account the account to set
     */
    public void setAccount(Integer account) {
        this.account = account;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }
    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    
}
