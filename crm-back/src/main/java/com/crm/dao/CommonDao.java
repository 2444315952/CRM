package com.crm.dao;

import com.crm.entity.Clue;
import com.crm.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonDao {

    /**
     * 查询所有客户
     * @return 实例对象
     */
    List<Clue> queryAllCustomer();

    /**
     * 查询所有产品
     * @return 实例对象
     */
    List<Product> queryAllProduct();
}
