package com.crm.controller;

import com.crm.service.TaskService;
import com.crm.vo.AjaxResponse;
import com.crm.vo.TaskVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * (Task)表控制层
 *
 * @author makejava
 * @since 2021-07-13 22:10:57
 */
@RestController
@RequestMapping("task")
public class TaskController {
    /**
     * 服务对象
     */
    @Resource
    private TaskService taskService;

    @GetMapping("selectAllTask")
    public List<TaskVo> selectAllTask(TaskVo vo ) {
        return this.taskService.selectAllTask();
    }

    /**
     * 新增
     */
    @PostMapping("/addTask")
    public AjaxResponse addFoladdTasklow(@RequestBody @Valid TaskVo taskVo){
        taskService.addTask(taskVo);
        return AjaxResponse.success(taskVo);
    }

    @PutMapping("/updateTask")
    public AjaxResponse updateTask(@RequestBody @Valid TaskVo taskVo){
        taskService.updateTask(taskVo);
        return AjaxResponse.success(taskVo);
    }
    @PutMapping("/updateState")
    public AjaxResponse updateState(@RequestBody @Valid TaskVo taskVo){
        taskService.updateState(taskVo);
        return AjaxResponse.success(taskVo);
    }

}