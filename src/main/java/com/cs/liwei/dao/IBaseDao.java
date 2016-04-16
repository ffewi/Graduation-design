package com.cs.liwei.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {
    /**
     * 基础操作 插入自动生成主键
     * @param obj
     * @return
     */
    Integer save(Object obj);
    /**
     * 基础操作 删除 根据主键删除
     * @param obj
     */
    void  delete(Object obj);
    /**
     * 基础操作 查找 需要传入主键id
     * @param obj
     * @return
     */
    Object findByID(Object obj,Serializable id);
    /**
     * 基础操作 查找 传入对象即可 全表查询
     * @param obj
     * @return
     */
    List<Object> findAll(Object obj);
    /**
     * 基础操作 更新 基于主键，且跟新全字段值，如果有空值，也会插入
     * @exception 主键为空是，报错！
     * @param obj
     */
    void update(Object obj);
}
