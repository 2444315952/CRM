package com.crm.service;

import com.crm.entity.RecordStatic;

import java.util.List;

/**
 * (RecordStatic)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 18:41:18
 */
public interface RecordStaticService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordStaticId 主键
     * @return 实例对象
     */
    RecordStatic queryById(Integer recordStaticId);
    List<RecordStatic> queryalls();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<RecordStatic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param recordStatic 实例对象
     * @return 实例对象
     */
    RecordStatic insert(RecordStatic recordStatic);

    /**
     * 修改数据
     *
     * @param recordStatic 实例对象
     * @return 实例对象
     */
    RecordStatic update(RecordStatic recordStatic);

    /**
     * 通过主键删除数据
     *
     * @param recordStaticId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recordStaticId);

}
