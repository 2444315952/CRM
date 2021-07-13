package com.crm.dao;

import com.crm.entity.RecordStatic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (RecordStatic)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 18:41:18
 */
@Mapper
public interface RecordStaticDao {

    /**
     * 通过ID查询单条数据
     *
     * @param recordStaticId 主键
     * @return 实例对象
     */
    RecordStatic queryById(Integer recordStaticId);
    List<RecordStatic> queryalls();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<RecordStatic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param recordStatic 实例对象
     * @return 对象列表
     */
    List<RecordStatic> queryAll(RecordStatic recordStatic);

    /**
     * 新增数据
     *
     * @param recordStatic 实例对象
     * @return 影响行数
     */
    int insert(RecordStatic recordStatic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RecordStatic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RecordStatic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RecordStatic> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<RecordStatic> entities);

    /**
     * 修改数据
     *
     * @param recordStatic 实例对象
     * @return 影响行数
     */
    int update(RecordStatic recordStatic);

    /**
     * 通过主键删除数据
     *
     * @param recordStaticId 主键
     * @return 影响行数
     */
    int deleteById(Integer recordStaticId);

}

