package com.crm.controller;

import com.crm.entity.Activity;
import com.crm.entity.AjaxResponse;
import com.crm.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ActivityController {
    @Resource
    private ActivityService activityService;

    @PostMapping("/addActivity")
    public AjaxResponse addActivity(@RequestBody @Valid Activity activity){
        activityService.addActivity(activity);
        return AjaxResponse.success(activity);
    }

    @GetMapping("/selectByActivityKey")
    public Activity selectByActivityKey(@RequestParam("id") Integer id){
        return activityService.selectByActivityKey(id);
    }

    @GetMapping("/selectByActivitys")
    public PageInfo<Activity> selectByActivitys(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Activity> list = activityService.selectByActivitys();
        PageInfo<Activity> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }



}
