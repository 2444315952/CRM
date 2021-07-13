package com.crm.service;

import com.crm.entity.Quotation;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Quotation)表服务接口
 *
 * @author makejava
 * @since 2021-07-14 04:26:18
 */
public interface QuotationService {

    /**
     * 通过ID查询单条数据
     *
     * @param quotationId 主键
     * @return 实例对象
     */
    Quotation queryById(Integer quotationId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    PageInfo<Quotation> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param quotation
     * @return 对象列表
     */
    PageInfo<Quotation> queryBySearch(Quotation quotation, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param quotation
     * @return 对象列表
     */
    PageInfo<Quotation> queryByScreen(Quotation quotation, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    Quotation insert(Quotation quotation);

    /**
     * 批量新增数据
     *
     * @param QuotationList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<Quotation> QuotationList);

    /**
     * 修改数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    Quotation update(Quotation quotation);

    /**
     * 批量修改数据
     *
     * @param quotationList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<Quotation> quotationList);

    /**
     * 通过主键删除数据
     *
     * @param quotationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer quotationId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
