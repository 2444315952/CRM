package com.crm.service.impl;

import com.crm.entity.LeadProduct;
import com.crm.dao.LeadProductDao;
import com.crm.service.LeadProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (LeadProduct)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 21:51:51
 */
@Service("leadProductService")
public class LeadProductServiceImpl implements LeadProductService {
    @Resource
    private LeadProductDao leadProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param leadProductId 主键
     * @return 实例对象
     */
    @Override
    public LeadProduct queryById(Integer leadProductId) {
        return this.leadProductDao.queryById(leadProductId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<LeadProduct> queryAll(Integer pageNum, Integer pageSize) {
        Page<LeadProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<LeadProduct> leadProductList = this.leadProductDao.queryAll();
        return new PageInfo<>(leadProductList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param leadProduct 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<LeadProduct> queryBySearch(LeadProduct leadProduct, Integer pageNum, Integer pageSize) {
        Page<LeadProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<LeadProduct> leadProductList = this.leadProductDao.queryOrByPojo(leadProduct);
        return new PageInfo<>(leadProductList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param leadProduct
     * @return 对象列表
     */
    @Override
    public PageInfo<LeadProduct> queryByScreen(LeadProduct leadProduct, Integer pageNum, Integer pageSize) {
        Page<LeadProduct> page = PageHelper.startPage(pageNum, pageSize);
        List<LeadProduct> leadProductList = this.leadProductDao.queryAndByPojo(leadProduct);
        return new PageInfo<>(leadProductList);
    }

    /**
     * 新增数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeadProduct insert(LeadProduct leadProduct) {
        this.leadProductDao.insert(leadProduct);
        return this.queryById(leadProduct.getLeadProductId());
    }

    /**
     * 批量新增数据
     *
     * @param leadProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<LeadProduct> leadProductList) {
        for (LeadProduct leadProduct : leadProductList)
            this.leadProductDao.insert(leadProduct);
        return true;
    }

    /**
     * 修改数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeadProduct update(LeadProduct leadProduct) {
        this.leadProductDao.update(leadProduct);
        return this.queryById(leadProduct.getLeadProductId());
    }

    /**
     * 批量修改数据
     *
     * @param leadProductList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<LeadProduct> leadProductList) {
        for (LeadProduct leadProduct : leadProductList)
            this.leadProductDao.insert(leadProduct);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param leadProductId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer leadProductId) {
        return this.leadProductDao.deleteById(leadProductId) > 0;
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
        int row = this.leadProductDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
