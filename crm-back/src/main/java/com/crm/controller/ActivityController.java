package com.crm.controller;

import com.crm.entity.Activity;
import com.crm.service.ActivityService;
import com.crm.vo.AjaxResponse;
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
    public List<Activity> selectByActivitys(){
        return activityService.selectByActivitys();
    }




}
