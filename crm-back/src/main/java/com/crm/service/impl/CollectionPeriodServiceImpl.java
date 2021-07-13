package com.crm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.crm.entity.CollectionPeriod;
import com.crm.dao.CollectionPeriodDao;
import com.crm.service.CollectionPeriodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CollectionPeriod)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 18:53:34
 */
@Service("collectionPeriodService")
public class CollectionPeriodServiceImpl implements CollectionPeriodService {
    @Resource
    private CollectionPeriodDao collectionPeriodDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    @Override
    public CollectionPeriod queryById(Integer collectionId) {
        return this.collectionPeriodDao.queryById(collectionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CollectionPeriod> queryAllByLimit(int offset, int limit) {
        return this.collectionPeriodDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param collectionPeriod 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionPeriod insert(CollectionPeriod collectionPeriod) {
        this.collectionPeriodDao.insert(collectionPeriod);
        return collectionPeriod;
    }

    @Override
    public JSONArray selectorderandperiodAll() {
        return this.collectionPeriodDao.selectorderandperiodAll();
    }

    @Override
    public JSONArray queryreceiptByorderid(int id) {
        return this.collectionPeriodDao.queryreceiptByorderid(id);
    }

    @Override
    public JSONArray queryByorder_idas(int id) {
        return this.collectionPeriodDao.queryByorder_idas(id);
    }

    @Override
    public JSONArray queryByhuikjl(int id) {
        return this.collectionPeriodDao.queryByhuikjl(id);
    }

    /**
     * 修改数据
     *
     * @param collectionPeriod 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionPeriod update(CollectionPeriod collectionPeriod) {
        this.collectionPeriodDao.update(collectionPeriod);
        return this.queryById(collectionPeriod.getCollectionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer collectionId) {
        return this.collectionPeriodDao.deleteById(collectionId) > 0;
    }

    @Override
    public JSONArray queryByOrderid_all(int id) {
        return this.collectionPeriodDao.queryByOrderid_all(id);
    }

    @Override
    public JSONArray selectorders() {
        return this.collectionPeriodDao.selectorders();
    }

    @Override
    public JSONArray queryhkjeandorderje(int id) {
        return this.collectionPeriodDao.queryhkjeandorderje(id);
    }

    @Override
    public JSONArray querykpje(int id) {
        return this.collectionPeriodDao.querykpje(id);
    }
}
