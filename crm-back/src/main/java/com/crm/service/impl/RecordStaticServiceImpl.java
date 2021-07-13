package com.crm.service.impl;

import com.crm.entity.RecordStatic;
import com.crm.dao.RecordStaticDao;
import com.crm.service.RecordStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RecordStatic)表服务实现类
 *
 * @author makejava
 * @since 2021-07-12 18:41:19
 */
@Service("recordStaticService")
public class RecordStaticServiceImpl implements RecordStaticService {
    @Resource
    private RecordStaticDao recordStaticDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recordStaticId 主键
     * @return 实例对象
     */
    @Override
    public RecordStatic queryById(Integer recordStaticId) {
        return this.recordStaticDao.queryById(recordStaticId);
    }

    @Override
    public List<RecordStatic> queryalls() {
        return this.recordStaticDao.queryalls();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<RecordStatic> queryAllByLimit(int offset, int limit) {
        return this.recordStaticDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param recordStatic 实例对象
     * @return 实例对象
     */
    @Override
    public RecordStatic insert(RecordStatic recordStatic) {
        this.recordStaticDao.insert(recordStatic);
        return recordStatic;
    }

    /**
     * 修改数据
     *
     * @param recordStatic 实例对象
     * @return 实例对象
     */
    @Override
    public RecordStatic update(RecordStatic recordStatic) {
        this.recordStaticDao.update(recordStatic);
        return this.queryById(recordStatic.getRecordStaticId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordStaticId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordStaticId) {
        return this.recordStaticDao.deleteById(recordStaticId) > 0;
    }
}
