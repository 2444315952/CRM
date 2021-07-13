package com.crm.service.impl;

import com.crm.dao.SaleProductDao;
import com.crm.entity.SaleLead;
import com.crm.dao.SaleLeadDao;
import com.crm.service.LeadProductService;
import com.crm.service.SaleLeadService;
import com.crm.service.SaleProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (SaleLead)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 16:27:48
 */
@Service("saleLeadService")
public class SaleLeadServiceImpl implements SaleLeadService {
    @Resource
    private SaleLeadDao saleLeadDao;

    @Resource
    private LeadProductService leadProductService;

    /**
     * 通过ID查询单条数据
     *
     * @param leadId 主键
     * @return 实例对象
     */
    @Override
    public SaleLead queryById(Integer leadId) {
        return this.saleLeadDao.queryById(leadId);
    }

    /**
     * 查询所有数据
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleLead> queryAll(Integer pageNum, Integer pageSize) {
        Page<SaleLead> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleLead> saleLeadList = this.saleLeadDao.queryAll();
        return new PageInfo<>(saleLeadList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleLead 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleLead> queryBySearch(SaleLead saleLead, Integer pageNum, Integer pageSize) {
        Page<SaleLead> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleLead> saleLeadList = this.saleLeadDao.queryOrByPojo(saleLead);
        return new PageInfo<>(saleLeadList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleLead
     * @return 对象列表
     */
    @Override
    public PageInfo<SaleLead> queryByScreen(SaleLead saleLead, Integer pageNum, Integer pageSize) {
        Page<SaleLead> page = PageHelper.startPage(pageNum, pageSize);
        List<SaleLead> saleLeadList = this.saleLeadDao.queryAndByPojo(saleLead);
        return new PageInfo<>(saleLeadList);
    }

    /**
     * 新增数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleLead insert(SaleLead saleLead) {
        this.saleLeadDao.insert(saleLead);
        saleLead.getLeadProductList().forEach(p->{
            p.setLeadId(saleLead.getLeadId());
        });
        leadProductService.insertBatch(saleLead.getLeadProductList());

        return this.queryById(saleLead.getLeadId());
    }

    /**
     * 批量新增数据
     *
     * @param saleLeadList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<SaleLead> saleLeadList) {
        for (SaleLead saleLead : saleLeadList)
            this.saleLeadDao.insert(saleLead);
        return true;
    }

    /**
     * 修改数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleLead update(SaleLead saleLead) {
        this.saleLeadDao.update(saleLead);
        return this.queryById(saleLead.getLeadId());
    }

    /**
     * 批量修改数据
     *
     * @param saleLeadList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<SaleLead> saleLeadList) {
        for (SaleLead saleLead : saleLeadList)
            this.saleLeadDao.insert(saleLead);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param leadId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer leadId) {
        return this.saleLeadDao.deleteById(leadId) > 0;
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
        int row = this.saleLeadDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
