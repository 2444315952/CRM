package com.crm.service.impl;

import com.crm.entity.Follow;
import com.crm.dao.FollowDao;
import com.crm.service.FollowService;
import com.crm.vo.FollowPlanVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Follow)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 15:03:16
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {
    @Resource
    private FollowDao dao;

    /**
     *
     *查询所有数据
     * @param
     * @return 实例对象
     */


    @Override
    public List<FollowPlanVo> selectAllFollow() {
        return dao.selectAllFollow();
    }

    @Override
    public List<FollowPlanVo> selectAllRecord() {
        return dao.selectAllRecord();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Follow> queryAllByLimit(int offset, int limit) {
        return this.dao.queryAllByLimit(offset, limit);
    }


    /**
     * 新增数据
     */
    @Override
    @Transactional
    public void addFollow(FollowPlanVo followPlanVo) {
        dao.addFollow(followPlanVo);
    }





    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer followId) {
        return this.dao.deleteById(followId) > 0;
    }

    @Override
    public int updateRecprd(FollowPlanVo followPlanVo) {
        return dao.updateRecprd(followPlanVo);
    }
}