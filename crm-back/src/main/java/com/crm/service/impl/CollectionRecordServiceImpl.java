package com.crm.service.impl;

import com.crm.entity.CollectionRecord;
import com.crm.dao.CollectionRecordDao;
import com.crm.service.CollectionRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CollectionRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 18:53:38
 */
@Service("collectionRecordService")
public class CollectionRecordServiceImpl implements CollectionRecordService {
    @Resource
    private CollectionRecordDao collectionRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    @Override
    public CollectionRecord queryById(Integer recordId) {
        return this.collectionRecordDao.queryById(recordId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CollectionRecord> queryAllByLimit(int offset, int limit) {
        return this.collectionRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param collectionRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionRecord insert(CollectionRecord collectionRecord) {
        this.collectionRecordDao.insert(collectionRecord);
        return collectionRecord;
    }

    /**
     * 修改数据
     *
     * @param collectionRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionRecord update(CollectionRecord collectionRecord) {
        this.collectionRecordDao.update(collectionRecord);
        return this.queryById(collectionRecord.getRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordId) {
        return this.collectionRecordDao.deleteById(recordId) > 0;
    }
}
