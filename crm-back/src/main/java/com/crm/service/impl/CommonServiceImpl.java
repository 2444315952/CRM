package com.crm.service.impl;

import com.crm.dao.CommonDao;
import com.crm.entity.Clue;
import com.crm.entity.Product;
import com.crm.service.CommonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonDao commonDao;

    /**
     * 查询所有客户
     * @return 对象列表
     */
    @Override
    public PageInfo<Clue> queryAllCustomer(Integer pageNum, Integer pageSize) {
        Page<Clue> page = PageHelper.startPage(pageNum, pageSize);
        List<Clue> clueList = this.commonDao.queryAllCustomer();
        return new PageInfo<>(clueList);
    }

    /**
     * 查询所有产品
     * @return 对象列表
     */
    @Override
    public PageInfo<Product> queryAllProduct(Integer pageNum, Integer pageSize) {
        Page<Product> page = PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = this.commonDao.queryAllProduct();
        return new PageInfo<>(productList);
    }
}
