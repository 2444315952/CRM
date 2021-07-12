package com.crm.service;

import com.crm.dao.HandleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HandleService {
    @Autowired
    private HandleDao handleDao;//出入库办理的dao层
    //查询未办理的出入库单
    public List<Map> findIfHandlerOInStore(){
        return handleDao.findIfHandlerOInStore();
    }
}
