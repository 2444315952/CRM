package com.crm.service;

import com.crm.entity.Receipt;

import java.util.List;

/**
 * (Receipt)表服务接口
 *
 * @author makejava
 * @since 2021-07-12 08:58:49
 */
public interface ReceiptService {

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    Receipt queryById(Integer receiptId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Receipt> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param receipt 实例对象
     * @return 实例对象
     */
    Receipt insert(Receipt receipt);

    /**
     * 修改数据
     *
     * @param receipt 实例对象
     * @return 实例对象
     */
    Receipt update(Receipt receipt);

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer receiptId);

}
