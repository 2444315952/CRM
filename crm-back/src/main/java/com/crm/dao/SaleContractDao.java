package com.crm.dao;

import com.crm.entity.SaleContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SaleContract)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 16:02:47
 */
@Mapper
public interface SaleContractDao {

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
    List<SaleContract> queryAll();

    /**
     * 通过实体作为或者条件查询
     *
     * @param saleContract 实例对象
     * @return 对象列表
     */
    List<SaleContract> queryOrByPojo(SaleContract saleContract);

    /**
     * 通过实体作为并且条件查询
     *
     * @param saleContract 实例对象
     * @return 对象列表
     */
    List<SaleContract> queryAndByPojo(SaleContract saleContract);

    /**
     * 新增数据
     *
     * @param saleContract 实例对象
     * @return 影响行数
     */
    int insert(SaleContract saleContract);

    /**
     * 修改数据
     *
     * @param saleContract 实例对象
     * @return 影响行数
     */
    int update(SaleContract saleContract);

    /**
     * 通过主键删除数据
     *
     * @param saleContractId 主键
     * @return 影响行数
     */
    int deleteById(Integer saleContractId);

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
     * @param saleContractList 实例对象列表
     * @return 影响行数
     */
    int deleteBatchByEntities(List<SaleContract> saleContractList);
}

