package com.crm.service;

import com.alibaba.fastjson.JSONArray;
import com.crm.entity.CollectionPeriod;

import java.util.List;

/**
 * (CollectionPeriod)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 18:53:34
 */
public interface CollectionPeriodService {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    CollectionPeriod queryById(Integer collectionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CollectionPeriod> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param collectionPeriod 实例对象
     * @return 实例对象
     */
    CollectionPeriod insert(CollectionPeriod collectionPeriod);
    JSONArray selectorderandperiodAll();
    JSONArray queryreceiptByorderid(int id);
    JSONArray queryByorder_idas(int id);
    JSONArray queryByhuikjl(int id);
    /**
     * 修改数据
     *
     * @param collectionPeriod 实例对象
     * @return 实例对象
     */
    CollectionPeriod update(CollectionPeriod collectionPeriod);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer collectionId);
    JSONArray queryByOrderid_all(int id);
    JSONArray selectorders();
    JSONArray queryhkjeandorderje(int id);
    JSONArray querykpje(int id);
}
