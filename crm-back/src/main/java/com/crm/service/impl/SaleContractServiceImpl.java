package com.crm.service.impl;

import com.crm.entity.SaleContract;
import com.crm.dao.SaleContractDao;
import com.crm.service.SaleContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (SaleContract)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 16:02:47
 */
@Service("saleContractService")
public class SaleContractServiceImpl implements SaleContractService {
    @Resource
    private SaleContractDao saleContractDao;

    /**
     * 通过ID查询单条数据
     *
     * @param saleContractId 主键
     * @return 实例对象
     */
    @Override
    public SaleContract queryById(Integer saleContractId) {
        return this.saleContractDao.queryById(saleContractId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleContract> queryAll(Integer pageNum, Integer pageSize,Integer leadId) {
        Page<SaleContract> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleContract> saleContractList = this.saleContractDao.queryAll(leadId);
        return new PageInfo<>(saleContractList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleContract 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleContract> queryBySearch(SaleContract saleContract, Integer pageNum, Integer pageSize) {
        Page<SaleContract> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleContract> saleContractList = this.saleContractDao.queryOrByPojo(saleContract);
        return new PageInfo<>(saleContractList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleContract
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleContract> queryByScreen(SaleContract saleContract, Integer pageNum, Integer pageSize) {
        Page<SaleContract> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleContract> saleContractList = this.saleContractDao.queryAndByPojo(saleContract);
        return new PageInfo<>(saleContractList);
    }

    /**
     * 新增数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleContract insert(SaleContract saleContract) {
        this.saleContractDao.insert(saleContract);
        return this.queryById(saleContract.getSaleContractId());
    }

    /**
     * 批量新增数据
     *
     * @param saleContractList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<SaleContract> saleContractList) {
        for (SaleContract saleContract : saleContractList)
            this.saleContractDao.insert(saleContract);
        return true;
    }

    /**
     * 修改数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleContract update(SaleContract saleContract) {
        this.saleContractDao.update(saleContract);
        return this.queryById(saleContract.getSaleContractId());
    }

    /**
     * 批量修改数据
     *
     * @param saleContractList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<SaleContract> saleContractList) {
        for (SaleContract saleContract : saleContractList)
            this.saleContractDao.insert(saleContract);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param saleContractId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer saleContractId) {
        return this.saleContractDao.deleteById(saleContractId) > 0;
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
        int row = this.saleContractDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
