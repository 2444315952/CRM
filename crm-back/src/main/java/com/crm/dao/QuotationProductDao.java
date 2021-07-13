package com.crm.dao;

import com.crm.entity.QuotationProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (QuotationProduct)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-14 04:25:50
 */
@Mapper
public interface QuotationProductDao {

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
    List<QuotationProduct> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param quotationProduct 实例对象
     * @return 对象列表
     */
    List<QuotationProduct> queryOrByPojo(QuotationProduct quotationProduct);

    /**
     * 通过实体作为并且条件查询
     *
     * @param quotationProduct 实例对象
     * @return 对象列表
     */
    List<QuotationProduct> queryAndByPojo(QuotationProduct quotationProduct);

    /**
     * 新增数据
     *
     * @param quotationProduct 实例对象
     * @return 影响行数
     */
    int insert(QuotationProduct quotationProduct);

    /**
     * 修改数据
     *
     * @param quotationProduct 实例对象
     * @return 影响行数
     */
    int update(QuotationProduct quotationProduct);

    /**
     * 通过主键删除数据
     *
     * @param quotationProductId 主键
     * @return 影响行数
     */
    int deleteById(Integer quotationProductId);

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
     * @param quotationProductList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<QuotationProduct> quotationProductList);
}

