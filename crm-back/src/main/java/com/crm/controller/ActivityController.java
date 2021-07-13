package com.crm.controller;

import com.crm.entity.Activity;
import com.crm.service.ActivityService;
import com.crm.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
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

    @GetMapping("/selectByMyActivitys")
    public List<Activity> selectByMyActivitys(){
        return activityService.selectByMyActivitys();
    }

    @PutMapping("/updateByActivityKeySelective")
    public AjaxResponse updateByActivityKeySelective(@RequestBody @Valid Activity activity){
        activityService.updateByActivityKeySelective(activity);
        return AjaxResponse.success(activity);
    }

    @PutMapping("/deleteByActivityKey")
    public AjaxResponse deleteByActivityKey(@RequestBody @Valid Activity activity){
        activityService.deleteByActivityKey(activity);
        return AjaxResponse.success(activity);
    }

    @PutMapping("/updateByStartActivity")
    public AjaxResponse updateByStartActivity(@RequestBody @Valid Activity activity){
        activity.setAddTime(new Date());
        activityService.updateByStartActivity(activity);
        return AjaxResponse.success(activity);
    }

    @PutMapping("/updateByEndActivity")
    public AjaxResponse updateByEndActivity(@RequestBody @Valid Activity activity){
        activity.setEndTime(new Date());
        activityService.updateByEndActivity(activity);
        return AjaxResponse.success(activity);
    }



}
