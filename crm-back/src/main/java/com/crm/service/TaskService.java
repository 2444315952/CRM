package com.crm.service;

import com.crm.entity.Task;
import com.crm.vo.TaskVo;

import java.util.List;

/**
 * (Task)表服务接口
 *
 * @author makejava
 * @since 2021-07-13 22:10:57
 */
public interface TaskService {

    /**
     * 查询所有任务
     */
    List<TaskVo> selectAllTask();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Task> queryAllByLimit(int offset, int limit);

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
     * @return 是否成功
     */
    boolean deleteById(Integer taskId);

}