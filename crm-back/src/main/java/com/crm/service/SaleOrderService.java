package com.crm.service;

import com.crm.entity.SaleOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleOrder)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 09:08:44
 */
public interface SaleOrderService {

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
    PageInfo<SaleOrder> queryAll(Integer pageNum, Integer pageSize, Integer leadId);

    /**
     * 根据查询条件搜索数据
     *
     * @param saleOrder
     * @return 对象列表
     */
    PageInfo<SaleOrder> queryBySearch(SaleOrder saleOrder, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param saleOrder
     * @return 对象列表
     */
    PageInfo<SaleOrder> queryByScreen(SaleOrder saleOrder, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder insert(SaleOrder saleOrder);

    /**
     * 批量新增数据
     *
     * @param SaleOrderList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<SaleOrder> SaleOrderList);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder update(SaleOrder saleOrder);

    /**
     * 批量修改数据
     *
     * @param saleOrderList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<SaleOrder> saleOrderList);

    /**
     * 通过主键删除数据
     *
     * @param saleOrderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer saleOrderId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
