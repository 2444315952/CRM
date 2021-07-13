package com.crm.service.impl;

import com.crm.entity.SaleProduct;
import com.crm.dao.SaleProductDao;
import com.crm.service.SaleProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (SaleProduct)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 21:46:33
 */
@Service("saleProductService")
public class SaleProductServiceImpl implements SaleProductService {
    @Resource
    private SaleProductDao saleProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param saleProductId 主键
     * @return 实例对象
     */
    @Override
    public SaleProduct queryById(Integer saleProductId) {
        return this.saleProductDao.queryById(saleProductId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleProduct> queryAll(Integer pageNum, Integer pageSize) {
        Page<SaleProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleProduct> saleProductList = this.saleProductDao.queryAll();
        return new PageInfo<>(saleProductList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleProduct 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleProduct> queryBySearch(SaleProduct saleProduct, Integer pageNum, Integer pageSize) {
        Page<SaleProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleProduct> saleProductList = this.saleProductDao.queryOrByPojo(saleProduct);
        return new PageInfo<>(saleProductList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleProduct
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleProduct> queryByScreen(SaleProduct saleProduct, Integer pageNum, Integer pageSize) {
        Page<SaleProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleProduct> saleProductList = this.saleProductDao.queryAndByPojo(saleProduct);
        return new PageInfo<>(saleProductList);
    }

    /**
     * 新增数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleProduct insert(SaleProduct saleProduct) {
        this.saleProductDao.insert(saleProduct);
        return this.queryById(saleProduct.getSaleProductId());
    }

    /**
     * 批量新增数据
     *
     * @param saleProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<SaleProduct> saleProductList) {
        for (SaleProduct saleProduct : saleProductList)
            this.saleProductDao.insert(saleProduct);
        return true;
    }

    /**
     * 修改数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleProduct update(SaleProduct saleProduct) {
        this.saleProductDao.update(saleProduct);
        return this.queryById(saleProduct.getSaleProductId());
    }

    /**
     * 批量修改数据
     *
     * @param saleProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<SaleProduct> saleProductList) {
        for (SaleProduct saleProduct : saleProductList)
            this.saleProductDao.insert(saleProduct);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param saleProductId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer saleProductId) {
        return this.saleProductDao.deleteById(saleProductId) > 0;
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
        int row = this.saleProductDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
