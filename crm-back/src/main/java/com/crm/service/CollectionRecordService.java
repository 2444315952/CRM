package com.crm.service;

import com.crm.entity.CollectionRecord;

import java.util.List;

/**
 * (CollectionRecord)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 18:53:37
 */
public interface CollectionRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    CollectionRecord queryById(Integer recordId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CollectionRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param collectionRecord 实例对象
     * @return 实例对象
     */
    CollectionRecord insert(CollectionRecord collectionRecord);

    /**
     * 修改数据
     *
     * @param collectionRecord 实例对象
     * @return 实例对象
     */
    CollectionRecord update(CollectionRecord collectionRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recordId);

}
