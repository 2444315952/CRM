package com.crm.service;

import com.crm.entity.QuotationProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (QuotationProduct)表服务接口
 *
 * @author makejava
 * @since 2021-07-14 04:25:50
 */
public interface QuotationProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param quotationProductId 主键
     * @return 实例对象
     */
    QuotationProduct queryById(Integer quotationProductId);

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    PageInfo<QuotationProduct> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件搜索数据
     *
     * @param quotationProduct
     * @return 对象列表
     */
    PageInfo<QuotationProduct> queryBySearch(QuotationProduct quotationProduct, Integer pageNum, Integer pageSize);

    /**
     * 根据查询条件筛选数据
     *
     * @param quotationProduct
     * @return 对象列表
     */
    PageInfo<QuotationProduct> queryByScreen(QuotationProduct quotationProduct, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    QuotationProduct insert(QuotationProduct quotationProduct);

    /**
     * 批量新增数据
     *
     * @param QuotationProductList 实例对象列表
     * @return 影响行数
     */
    boolean insertBatch(List<QuotationProduct> QuotationProductList);

    /**
     * 修改数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    QuotationProduct update(QuotationProduct quotationProduct);

    /**
     * 批量修改数据
     *
     * @param quotationProductList 实例对象列表
     * @return 影响行数
     */
    boolean updateBatch(List<QuotationProduct> quotationProductList);

    /**
     * 通过主键删除数据
     *
     * @param quotationProductId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer quotationProductId);

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    boolean deleteBatch(List<Integer> ids);
}
