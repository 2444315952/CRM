package com.crm.service;

import com.crm.dao.ActivityDao;
import com.crm.entity.Activity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;
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
}
