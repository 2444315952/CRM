package com.crm.dao;

import com.crm.entity.CollectionRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (CollectionRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 18:53:37
 */
@Mapper
public interface CollectionRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    CollectionRecord queryById(Integer recordId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CollectionRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param collectionRecord 实例对象
     * @return 对象列表
     */
    List<CollectionRecord> queryAll(CollectionRecord collectionRecord);

    /**
     * 新增数据
     *
     * @param collectionRecord 实例对象
     * @return 影响行数
     */
    int insert(CollectionRecord collectionRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CollectionRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CollectionRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CollectionRecord> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CollectionRecord> entities);

    /**
     * 修改数据
     *
     * @param collectionRecord 实例对象
     * @return 影响行数
     */
    int update(CollectionRecord collectionRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 影响行数
     */
    int deleteById(Integer recordId);

}

