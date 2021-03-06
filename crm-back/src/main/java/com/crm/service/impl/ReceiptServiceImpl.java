package com.crm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.crm.dao.ReceiptDao;
import com.crm.entity.Receipt;
import com.crm.service.ReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Receipt)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 08:58:49
 */
@Service("receiptService")
public class ReceiptServiceImpl implements ReceiptService {
    @Resource
    private ReceiptDao receiptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    @Override
    public Receipt queryById(Integer receiptId) {
        return this.receiptDao.queryById(receiptId);
    }

    @Override
    public JSONArray selectReceipt() {
        return this.receiptDao.selectReceipt();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Receipt> queryAllByLimit(int offset, int limit) {
        return this.receiptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param receipt 实例对象
     * @return 实例对象
     */
    @Override
    public Receipt insert(Receipt receipt) {
        this.receiptDao.insert(receipt);
        return receipt;
    }

    @Override
    public JSONArray queryreceipt(int id) {
        return this.receiptDao.queryreceipt(id);
    }

    @Override
    public void updatesreceiptone(int id) {
        this.receiptDao.updatesreceiptone(id);
    }

    @Override
    public void updatesreceipttwo(int id) {
        this.receiptDao.updatesreceipttwo(id);
    }

    @Override
    public void updatesreceiptzero(int id) {
        this.receiptDao.updatesreceiptzero(id);
    }

    /**
     * 修改数据
     *
     * @param receipt 实例对象
     * @return 实例对象
     */
    @Override
    public Receipt update(Receipt receipt) {
        this.receiptDao.update(receipt);
        return this.queryById(receipt.getReceiptId());
    }

    @Override
    public JSONArray selectReceiptapplyone() {
        return this.receiptDao.selectReceiptapplyone();
    }

    @Override
    public JSONArray selectReceiptapplytwo() {
        return this.receiptDao.selectReceiptapplytwo();
    }

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer receiptId) {
        return this.receiptDao.deleteById(receiptId) > 0;
    }
}
