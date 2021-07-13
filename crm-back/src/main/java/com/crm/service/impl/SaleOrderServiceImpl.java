package com.crm.service.impl;

import com.crm.entity.SaleOrder;
import com.crm.dao.SaleOrderDao;
import com.crm.service.SaleOrderService;
import com.crm.service.SaleProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (SaleOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 09:08:44
 */
@Service("saleOrderService")
public class SaleOrderServiceImpl implements SaleOrderService {
    @Resource
    private SaleOrderDao saleOrderDao;

    @Resource
    private SaleProductService saleProductService;

    /**
     * 通过ID查询单条数据
     *
     * @param saleOrderId 主键
     * @return 实例对象
     */
    @Override
    public SaleOrder queryById(Integer saleOrderId) {
        return this.saleOrderDao.queryById(saleOrderId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleOrder> queryAll(Integer pageNum, Integer pageSize, Integer leadId) {
        Page<SaleOrder> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleOrder> saleOrderList = this.saleOrderDao.queryAll(leadId);
        return new PageInfo<>(saleOrderList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleOrder 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleOrder> queryBySearch(SaleOrder saleOrder, Integer pageNum, Integer pageSize) {
        Page<SaleOrder> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleOrder> saleOrderList = this.saleOrderDao.queryOrByPojo(saleOrder);
        return new PageInfo<>(saleOrderList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleOrder
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleOrder> queryByScreen(SaleOrder saleOrder, Integer pageNum, Integer pageSize) {
        Page<SaleOrder> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleOrder> saleOrderList = this.saleOrderDao.queryAndByPojo(saleOrder);
        return new PageInfo<>(saleOrderList);
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleOrder insert(SaleOrder saleOrder) {
        this.saleOrderDao.insert(saleOrder);

        saleOrder.getSaleProductList().forEach(p->{
            p.setSaleOrderId(saleOrder.getSaleOrderId());
        });
        saleProductService.insertBatch(saleOrder.getSaleProductList());

        return this.queryById(saleOrder.getSaleOrderId());
    }

    /**
     * 批量新增数据
     *
     * @param saleOrderList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<SaleOrder> saleOrderList) {
        for (SaleOrder saleOrder : saleOrderList)
            this.saleOrderDao.insert(saleOrder);
        return true;
    }

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleOrder update(SaleOrder saleOrder) {
        this.saleOrderDao.update(saleOrder);
        return this.queryById(saleOrder.getSaleOrderId());
    }

    /**
     * 批量修改数据
     *
     * @param saleOrderList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<SaleOrder> saleOrderList) {
        for (SaleOrder saleOrder : saleOrderList)
            this.saleOrderDao.insert(saleOrder);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param saleOrderId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer saleOrderId) {
        return this.saleOrderDao.deleteById(saleOrderId) > 0;
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
        int row = this.saleOrderDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
