package com.crm.service;

import com.crm.entity.Follow;
import com.crm.vo.FollowPlanVo;

import java.util.List;

/**
 * (Follow)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 15:03:16
 */
public interface FollowService {

    /**
     * 查询所有数据
     */
    List<FollowPlanVo> selectAllFollow();
    List<FollowPlanVo>  selectAllRecord();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Follow> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param
     * @return 实例对象
     */
    void addFollow(FollowPlanVo followPlanVo);


    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer followId);
    int updateRecprd(FollowPlanVo followPlanVo);
}