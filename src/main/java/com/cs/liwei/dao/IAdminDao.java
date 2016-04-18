package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;

/**
 * 
 * 类/接口注释 DAO层 方法 定义
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public interface IAdminDao extends IBaseDao {
    /*
     * 增 删 改 查 定义一些其他特殊的操作
     */
    void searchAllExample();

    /**
     * 获取dept 所有信息，且分页
     * 
     * @param pageNO
     * @param pageSize
     * @return
     */
    List<Dept> getDeptByPage(int pageNO, int pageSize);

    /**
     * 用户登录检查
     * 
     * @param admin
     * @return
     */
    boolean checkUser(Admin admin);
}
