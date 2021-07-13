package com.crm.dao;

import com.alibaba.fastjson.JSONArray;
import com.crm.entity.Receipt;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Receipt)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-12 08:59:14
 */
@Mapper
public interface ReceiptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param receiptId 主键
     * @return 实例对象
     */
    Receipt queryById(Integer receiptId);

    JSONArray selectReceipt();

    JSONArray selectReceiptapplyone();

    JSONArray selectReceiptapplytwo();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Receipt> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param receipt 实例对象
     * @return 对象列表
     */
    List<Receipt> queryAll(Receipt receipt);

    JSONArray queryreceipt(int id);

    void updatesreceiptone(int id);
    void updatesreceipttwo(int id);
    void updatesreceiptzero(int id);
    /**
     * 新增数据
     *
     * @param receipt 实例对象
     * @return 影响行数
     */
    int insert(Receipt receipt);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Receipt> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Receipt> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Receipt> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Receipt> entities);

    /**
     * 修改数据
     *
     * @param receipt 实例对象
     * @return 影响行数
     */
    int update(Receipt receipt);

    /**
     * 通过主键删除数据
     *
     * @param receiptId 主键
     * @return 影响行数
     */
    int deleteById(Integer receiptId);

}

