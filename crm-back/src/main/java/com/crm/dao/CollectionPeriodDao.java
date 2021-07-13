package com.crm.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.CollectionPeriod;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CollectionPeriod)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 18:53:34
 */
@Mapper
public interface CollectionPeriodDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    CollectionPeriod queryById(Integer collectionId);

    JSONArray selectorderandperiodAll();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CollectionPeriod> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    JSONArray queryreceiptByorderid(int id);
    JSONArray queryByorder_idas(int id);
    JSONArray queryByhuikjl(int id);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param collectionPeriod 实例对象
     * @return 对象列表
     */
    List<CollectionPeriod> queryAll(CollectionPeriod collectionPeriod);

    /**
     * 新增数据
     *
     * @param collectionPeriod 实例对象
     * @return 影响行数
     */
    int insert(CollectionPeriod collectionPeriod);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CollectionPeriod> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CollectionPeriod> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CollectionPeriod> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CollectionPeriod> entities);

    /**
     * 修改数据
     *
     * @param collectionPeriod 实例对象
     * @return 影响行数
     */
    int update(CollectionPeriod collectionPeriod);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 影响行数
     */
    int deleteById(Integer collectionId);

    JSONArray queryByOrderid_all(int id);
    JSONArray selectorders();

    JSONArray queryhkjeandorderje(int id);
    JSONArray querykpje(int id);
}

