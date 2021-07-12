package com.crm.dao;

import com.crm.entity.SaleLead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SaleLead)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 16:27:47
 */
@Mapper
public interface SaleLeadDao {

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
    List<SaleLead> queryAll(SaleLead saleLead);

    /**
     * 通过实体作为或者条件查询
     *
     * @param saleLead 实例对象
     * @return 对象列表
     */
    List<SaleLead> queryOrByPojo(SaleLead saleLead);

    /**
     * 通过实体作为并且条件查询
     *
     * @param saleLead 实例对象
     * @return 对象列表
     */
    List<SaleLead> queryAndByPojo(SaleLead saleLead);

    /**
     * 新增数据
     *
     * @param saleLead 实例对象
     * @return 影响行数
     */
    int insert(SaleLead saleLead);

    /**
     * 修改数据
     *
     * @param saleLead 实例对象
     * @return 影响行数
     */
    int update(SaleLead saleLead);

    /**
     * 通过主键删除数据
     *
     * @param leadId 主键
     * @return 影响行数
     */
    int deleteById(Integer leadId);

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
     * @param saleLeadList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<SaleLead> saleLeadList);
}

