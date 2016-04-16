package com.cs.liwei.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {
    /**
     * 基础操作 插入
     * @param obj
     * @return
     */
    Integer save(Object obj);
    /**
     * 基础操作 删除
     * @param obj
     */
    void  delete(Object obj);
    /**
     * 基础操作 查找
     * @param obj
     * @return
     */
    Object findByID(Object obj,Serializable id);
    /**
     * 基础操作 查找
     * @param obj
     * @return
     */
    List<Object> findAll(Object obj);
    /**
     * 基础操作 更新
     * @param obj
     */
    void update(Object obj);
}
