package com.crm.dao;

import com.crm.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 15:31:21
 */
@Mapper
public interface ProductDao {

    /**
     * 通过ID查询单条数据
     */
    Product queryById(Integer proId);

    /**
     * 查询指定行数据
     */
    List<Product> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     */
    List<Product> queryAll(Product product);

    /**
     * 新增数据
     *
     */
    int insert(Product product);

    /**
     * 批量新增数据（MyBatis原生foreach方法）

     */
    int insertBatch(@Param("entities") List<Product> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Product> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Product> entities);

    /**
     * 修改数据
     */
    int update(Product product);

    /**
     * 通过主键删除数据
     *
     */
    int deleteById(Integer proId);


    //查询产品库中所有的产品
    List<Product> getAll();

}

