package com.crm.service;

import com.crm.entity.SaleLead;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleLead)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 16:27:47
 */
public interface SaleLeadService {

    /**
     * 通过ID查询单条数据
     *
     * @param leadId 主键
     * @return 实例对象
     */
    SaleLead queryById(Integer leadId);

    /**
     * 查询所有数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    PageInfo<SaleLead> queryAll(SaleLead saleLead, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param saleLead
     * @return 对象列表
     */
    PageInfo<SaleLead> queryBySearch(SaleLead saleLead, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param saleLead
     * @return 对象列表
     */
    PageInfo<SaleLead> queryByScreen(SaleLead saleLead, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    SaleLead insert(SaleLead saleLead);

    /**
     * 批量新增数据
     *
     * @param SaleLeadList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<SaleLead> SaleLeadList);

    /**
     * 修改数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    SaleLead update(SaleLead saleLead);

    /**
     * 批量修改数据
     *
     * @param saleLeadList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<SaleLead> saleLeadList);

    /**
     * 通过主键删除数据
     *
     * @param leadId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer leadId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
