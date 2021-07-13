package com.crm.service.impl;

import com.crm.dao.ActivityDao;
import com.crm.dao.ClueDao;
import com.crm.entity.Activity;
import com.crm.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;

//    @Resource
//    private ClueDao clueDao;

    @Transactional
    @Override
    public int addActivity(Activity record) {
        return activityDao.addActivity(record);
    }

    @Override
    public Activity selectByActivityKey(Integer activityId) {
        return activityDao.selectByActivityKey(activityId);
    }

    @Override
    public List<Activity> selectByActivitys() {
        return activityDao.selectByActivitys();
    }

    @Override
    public List<Activity> selectByMyActivitys() {
        return activityDao.selectByMyActivitys();
    }

    @Transactional
    @Override
    public int updateByActivityKeySelective(Activity record) {
        return activityDao.updateByActivityKeySelective(record);
    }

    @Transactional
    @Override
    public int deleteByActivityKey(Activity record) {
        return activityDao.updateByActivityKey(record);
    }

    @Transactional
    @Override
    public int updateByStartActivity(Activity record) {
        return activityDao.updateByStartActivity(record);
    }

    @Transactional
    @Override
    public int updateByEndActivity(Activity record) {
        return activityDao.updateByEndActivity(record);
    }

}
