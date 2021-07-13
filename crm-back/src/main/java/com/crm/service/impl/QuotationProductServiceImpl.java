package com.crm.service.impl;

import com.crm.entity.QuotationProduct;
import com.crm.dao.QuotationProductDao;
import com.crm.service.QuotationProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (QuotationProduct)表服务实现类
 *
 * @author makejava
 * @since 2021-07-14 04:25:50
 */
@Service("quotationProductService")
public class QuotationProductServiceImpl implements QuotationProductService {
    @Resource
    private QuotationProductDao quotationProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param quotationProductId 主键
     * @return 实例对象
     */
    @Override
    public QuotationProduct queryById(Integer quotationProductId) {
        return this.quotationProductDao.queryById(quotationProductId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<QuotationProduct> queryAll(Integer pageNum, Integer pageSize) {
        Page<QuotationProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<QuotationProduct> quotationProductList = this.quotationProductDao.queryAll();
        return new PageInfo<>(quotationProductList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param quotationProduct 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<QuotationProduct> queryBySearch(QuotationProduct quotationProduct, Integer pageNum, Integer pageSize) {
        Page<QuotationProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<QuotationProduct> quotationProductList = this.quotationProductDao.queryOrByPojo(quotationProduct);
        return new PageInfo<>(quotationProductList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param quotationProduct
     * @return 对象列表
     */
    @Override
    public PageInfo<QuotationProduct> queryByScreen(QuotationProduct quotationProduct, Integer pageNum, Integer pageSize) {
        Page<QuotationProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<QuotationProduct> quotationProductList = this.quotationProductDao.queryAndByPojo(quotationProduct);
        return new PageInfo<>(quotationProductList);
    }

    /**
     * 新增数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public QuotationProduct insert(QuotationProduct quotationProduct) {
        this.quotationProductDao.insert(quotationProduct);
        return this.queryById(quotationProduct.getQuotationProductId());
    }

    /**
     * 批量新增数据
     *
     * @param quotationProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<QuotationProduct> quotationProductList) {
        for (QuotationProduct quotationProduct : quotationProductList)
            this.quotationProductDao.insert(quotationProduct);
        return true;
    }

    /**
     * 修改数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public QuotationProduct update(QuotationProduct quotationProduct) {
        this.quotationProductDao.update(quotationProduct);
        return this.queryById(quotationProduct.getQuotationProductId());
    }

    /**
     * 批量修改数据
     *
     * @param quotationProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<QuotationProduct> quotationProductList) {
        for (QuotationProduct quotationProduct : quotationProductList)
            this.quotationProductDao.insert(quotationProduct);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param quotationProductId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer quotationProductId) {
        return this.quotationProductDao.deleteById(quotationProductId) > 0;
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteBatch(List<Integer> ids) {
        int row = this.quotationProductDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
