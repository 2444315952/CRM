package com.crm.dao;

import com.crm.entity.LeadProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (LeadProduct)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 21:51:50
 */
@Mapper
public interface LeadProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param leadProductId 主键
     * @return 实例对象
     */
    LeadProduct queryById(Integer leadProductId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    List<LeadProduct> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param leadProduct 实例对象
     * @return 对象列表
     */
    List<LeadProduct> queryOrByPojo(LeadProduct leadProduct);

    /**
     * 通过实体作为并且条件查询
     *
     * @param leadProduct 实例对象
     * @return 对象列表
     */
    List<LeadProduct> queryAndByPojo(LeadProduct leadProduct);

    /**
     * 新增数据
     *
     * @param leadProduct 实例对象
     * @return 影响行数
     */
    int insert(LeadProduct leadProduct);

    /**
     * 修改数据
     *
     * @param leadProduct 实例对象
     * @return 影响行数
     */
    int update(LeadProduct leadProduct);

    /**
     * 通过主键删除数据
     *
     * @param leadProductId 主键
     * @return 影响行数
     */
    int deleteById(Integer leadProductId);

    /**
     * 通过主键列表删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    int deleteBatch(List<Integer> ids);

    /**
     * 批量对象列表删除数据
     *
     * @param leadProductList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<LeadProduct> leadProductList);
}

