package com.crm.dao;

import com.crm.entity.SaleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SaleOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 09:08:42
 */
@Mapper
public interface SaleOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param saleOrderId 主键
     * @return 实例对象
     */
    SaleOrder queryById(Integer saleOrderId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    List<SaleOrder> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param saleOrder 实例对象
     * @return 对象列表
     */
    List<SaleOrder> queryOrByPojo(SaleOrder saleOrder);

    /**
     * 通过实体作为并且条件查询
     *
     * @param saleOrder 实例对象
     * @return 对象列表
     */
    List<SaleOrder> queryAndByPojo(SaleOrder saleOrder);

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int insert(SaleOrder saleOrder);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int update(SaleOrder saleOrder);

    /**
     * 通过主键删除数据
     *
     * @param saleOrderId 主键
     * @return 影响行数
     */
    int deleteById(Integer saleOrderId);

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
     * @param saleOrderList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<SaleOrder> saleOrderList);
}

