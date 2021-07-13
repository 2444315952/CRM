package com.crm.service.impl;

import com.crm.entity.Task;
import com.crm.dao.TaskDao;
import com.crm.service.TaskService;
import com.crm.vo.TaskVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Task)表服务实现类
 *
 * @author makejava
 * @since 2021-07-13 22:10:57
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao dao;


    @Override
    public List<TaskVo> selectAllTask() {
        return dao.selectAllTask();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Task> queryAllByLimit(int offset, int limit) {
        return this.dao.queryAllByLimit(offset, limit);
    }

    @Override
    public void addTask(TaskVo taskVo) {
        dao.addTask(taskVo);
    }

    @Override
    public int updateTask(TaskVo taskVo) {
        return dao.updateTask(taskVo);
    }

    @Override
    public int updateState(TaskVo taskVo) {
        return dao.updateState(taskVo);
    }

    /**
     * 新增数据
     */


    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 实例对象
     */


    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer taskId) {
        return this.dao.deleteById(taskId) > 0;
    }
}