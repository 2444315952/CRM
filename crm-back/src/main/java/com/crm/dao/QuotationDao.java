package com.crm.dao;

import com.crm.entity.Quotation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Quotation)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-14 04:26:18
 */
@Mapper
public interface QuotationDao {

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
    List<Quotation> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param quotation 实例对象
     * @return 对象列表
     */
    List<Quotation> queryOrByPojo(Quotation quotation);

    /**
     * 通过实体作为并且条件查询
     *
     * @param quotation 实例对象
     * @return 对象列表
     */
    List<Quotation> queryAndByPojo(Quotation quotation);

    /**
     * 新增数据
     *
     * @param quotation 实例对象
     * @return 影响行数
     */
    int insert(Quotation quotation);

    /**
     * 修改数据
     *
     * @param quotation 实例对象
     * @return 影响行数
     */
    int update(Quotation quotation);

    /**
     * 通过主键删除数据
     *
     * @param quotationId 主键
     * @return 影响行数
     */
    int deleteById(Integer quotationId);

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
     * @param quotationList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<Quotation> quotationList);
}

