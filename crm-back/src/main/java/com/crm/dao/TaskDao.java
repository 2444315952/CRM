package com.crm.dao;

import com.crm.entity.Task;
import com.crm.vo.TaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Task)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-13 22:10:57
 */
@Mapper
public interface TaskDao {

    /**
     * @param
     * @return 实例对象
     */
    List<TaskVo> selectAllTask();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Task> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param task 实例对象
     * @return 对象列表
     */
    List<Task> queryAll(Task task);

    /**
     * 新增数据
     */
    void addTask(TaskVo taskVo);

   int updateTask(TaskVo taskVo);
  int updateState(TaskVo taskVo);
    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 影响行数
     */
    int deleteById(Integer taskId);

}