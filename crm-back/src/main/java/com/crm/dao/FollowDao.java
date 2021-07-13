package com.crm.dao;

import com.crm.entity.Follow;
import com.crm.vo.FollowPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * (Follow)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 15:03:16
 */
@Mapper
public interface FollowDao {

    /**
     * 查询所有数据
     *
     * @param
     * @return 实例对象
     */
    List<FollowPlanVo> selectAllFollow();
    List<FollowPlanVo>  selectAllRecord();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Follow> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param follow 实例对象
     * @return 对象列表
     */
    List<Follow> queryAll(Follow follow);

    /**
     * 新增数据
     *
     * @param
     * @return 影响行数
     */
    void addFollow(FollowPlanVo followPlanVo);

    /**
     * 修改数据
     *
     * @param follow 实例对象
     * @return 影响行数
     */


    /**
     * 通过主键删除数据
     *
     * @param followId 主键
     * @return 影响行数
     */
    int deleteById(Integer followId);
    int updateRecprd(FollowPlanVo followPlanVo);
}