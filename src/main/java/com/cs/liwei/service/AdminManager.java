package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;

public interface AdminManager {
    /**
     * some interface method
     */
    void example();

    /**
     * 获取dept 按照指定的页面 及其 页面大小 显示
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Dept> getAllByPage(int pageNo, int pageSize);

    /**
     * 登录检查 admin
     * 成功：true  不成功：false
     * @param admin
     * @return
     */
    boolean checkLogin(Admin admin);
}
