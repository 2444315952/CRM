package com.crm.service.impl;

import com.crm.entity.Quotation;
import com.crm.dao.QuotationDao;
import com.crm.service.QuotationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Quotation)表服务实现类
 *
 * @author makejava
 * @since 2021-07-14 04:26:18
 */
@Service("quotationService")
public class QuotationServiceImpl implements QuotationService {
    @Resource
    private QuotationDao quotationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param quotationId 主键
     * @return 实例对象
     */
    @Override
    public Quotation queryById(Integer quotationId) {
        return this.quotationDao.queryById(quotationId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public PageInfo<Quotation> queryAll(Integer pageNum, Integer pageSize) {
        Page<Quotation> page = PageHelper.startPage(pageNum, pageSize);
        List<Quotation> quotationList = this.quotationDao.queryAll();
        return new PageInfo<>(quotationList);
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param quotation 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<Quotation> queryBySearch(Quotation quotation, Integer pageNum, Integer pageSize) {
        Page<Quotation> page = PageHelper.startPage(pageNum, pageSize);
        List<Quotation> quotationList = this.quotationDao.queryOrByPojo(quotation);
        return new PageInfo<>(quotationList);
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param quotation
     * @return 对象列表
     */
    @Override
    public PageInfo<Quotation> queryByScreen(Quotation quotation, Integer pageNum, Integer pageSize) {
        Page<Quotation> page = PageHelper.startPage(pageNum, pageSize);
        List<Quotation> quotationList = this.quotationDao.queryAndByPojo(quotation);
        return new PageInfo<>(quotationList);
    }

    /**
     * 新增数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Quotation insert(Quotation quotation) {
        this.quotationDao.insert(quotation);
        return this.queryById(quotation.getQuotationId());
    }

    /**
     * 批量新增数据
     *
     * @param quotationList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBatch(List<Quotation> quotationList) {
        for (Quotation quotation : quotationList)
            this.quotationDao.insert(quotation);
        return true;
    }

    /**
     * 修改数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Quotation update(Quotation quotation) {
        this.quotationDao.update(quotation);
        return this.queryById(quotation.getQuotationId());
    }

    /**
     * 批量修改数据
     *
     * @param quotationList 实例对象列表
     * @return 影响行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatch(List<Quotation> quotationList) {
        for (Quotation quotation : quotationList)
            this.quotationDao.insert(quotation);
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param quotationId 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer quotationId) {
        return this.quotationDao.deleteById(quotationId) > 0;
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
        int row = this.quotationDao.deleteBatch(ids);
        return ids.size() == row;
    }
}
