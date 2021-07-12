package com.crm.service;

import com.crm.entity.Activity;

import java.util.List;

public interface ActivityService {
    int addActivity(Activity record);

    Activity selectByActivityKey(Integer activityId);

    List<Activity> selectByActivitys();

    int updateByActivityKeySelective(Activity record);

    int deleteByActivityKey(Activity record);
}
