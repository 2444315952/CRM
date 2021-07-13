package com.crm.service;

import com.crm.entity.SaleProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleProduct)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 21:46:33
 */
public interface SaleProductService {

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
    PageInfo<SaleProduct> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param saleProduct
     * @return 对象列表
     */
    PageInfo<SaleProduct> queryBySearch(SaleProduct saleProduct, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param saleProduct
     * @return 对象列表
     */
    PageInfo<SaleProduct> queryByScreen(SaleProduct saleProduct, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    SaleProduct insert(SaleProduct saleProduct);

    /**
     * 批量新增数据
     *
     * @param SaleProductList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<SaleProduct> SaleProductList);

    /**
     * 修改数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    SaleProduct update(SaleProduct saleProduct);

    /**
     * 批量修改数据
     *
     * @param saleProductList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<SaleProduct> saleProductList);

    /**
     * 通过主键删除数据
     *
     * @param saleProductId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer saleProductId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
