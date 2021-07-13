package com.crm.dao;

import com.crm.entity.SaleProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SaleProduct)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 21:46:32
 */
@Mapper
public interface SaleProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param saleProductId 主键
     * @return 实例对象
     */
    SaleProduct queryById(Integer saleProductId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    List<SaleProduct> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param saleProduct 实例对象
     * @return 对象列表
     */
    List<SaleProduct> queryOrByPojo(SaleProduct saleProduct);

    /**
     * 通过实体作为并且条件查询
     *
     * @param saleProduct 实例对象
     * @return 对象列表
     */
    List<SaleProduct> queryAndByPojo(SaleProduct saleProduct);

    /**
     * 新增数据
     *
     * @param saleProduct 实例对象
     * @return 影响行数
     */
    int insert(SaleProduct saleProduct);

    /**
     * 修改数据
     *
     * @param saleProduct 实例对象
     * @return 影响行数
     */
    int update(SaleProduct saleProduct);

    /**
     * 通过主键删除数据
     *
     * @param saleProductId 主键
     * @return 影响行数
     */
    int deleteById(Integer saleProductId);

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
     * @param saleProductList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<SaleProduct> saleProductList);
}

