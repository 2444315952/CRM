package com.crm.service;

import com.crm.entity.SaleContract;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleContract)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 16:02:47
 */
public interface SaleContractService {

    /**
     * 通过ID查询单条数据
     *
     * @param saleContractId 主键
     * @return 实例对象
     */
    SaleContract queryById(Integer saleContractId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    PageInfo<SaleContract> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param saleContract
     * @return 对象列表
     */
    PageInfo<SaleContract> queryBySearch(SaleContract saleContract, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param saleContract
     * @return 对象列表
     */
    PageInfo<SaleContract> queryByScreen(SaleContract saleContract, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    SaleContract insert(SaleContract saleContract);

    /**
     * 批量新增数据
     *
     * @param SaleContractList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<SaleContract> SaleContractList);

    /**
     * 修改数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    SaleContract update(SaleContract saleContract);

    /**
     * 批量修改数据
     *
     * @param saleContractList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<SaleContract> saleContractList);

    /**
     * 通过主键删除数据
     *
     * @param saleContractId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer saleContractId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
