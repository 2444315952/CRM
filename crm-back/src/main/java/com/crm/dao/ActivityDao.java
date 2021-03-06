package com.crm.dao;

import com.crm.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {

    int addActivity(Activity record);

    Activity selectByActivityKey(Integer activityId);

    List<Activity> selectByActivitys();

    List<Activity> selectByMyActivitys();

    int updateByActivityKeySelective(Activity record);

    int updateByActivityKey(Activity record);

    int updateByStartActivity(Activity record);

    int updateByEndActivity(Activity record);

}