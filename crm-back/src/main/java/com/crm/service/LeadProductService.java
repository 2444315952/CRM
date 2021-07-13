package com.crm.service;

import com.crm.entity.LeadProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (LeadProduct)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 21:51:51
 */
public interface LeadProductService {

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
    PageInfo<LeadProduct> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param leadProduct
     * @return 对象列表
     */
    PageInfo<LeadProduct> queryBySearch(LeadProduct leadProduct, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param leadProduct
     * @return 对象列表
     */
    PageInfo<LeadProduct> queryByScreen(LeadProduct leadProduct, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    LeadProduct insert(LeadProduct leadProduct);

    /**
     * 批量新增数据
     *
     * @param LeadProductList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<LeadProduct> LeadProductList);

    /**
     * 修改数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    LeadProduct update(LeadProduct leadProduct);

    /**
     * 批量修改数据
     *
     * @param leadProductList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<LeadProduct> leadProductList);

    /**
     * 通过主键删除数据
     *
     * @param leadProductId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer leadProductId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
