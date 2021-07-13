package com.crm.service;

import com.crm.entity.Clue;
import com.crm.entity.Product;
import com.github.pagehelper.PageInfo;

public interface CommonService {

    /**
     * 查询所有客户
     * @return 实例对象
     */
    PageInfo<Clue> queryAllCustomer(Integer pageNum, Integer pageSize);

    /**
     * 查询所有产品
     * @return 实例对象
     */
    PageInfo<Product> queryAllProduct(Integer pageNum, Integer pageSize);

}
