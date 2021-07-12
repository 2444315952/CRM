package com.crm.dao;


import com.crm.entity.Handle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//出入库办理的dao层
@Mapper
public interface HandleDao {
    //查询未办理的出入库单
    List<Map> findIfHandlerOInStore();

    int deleteByPrimaryKey(Integer hid);

    int insert(Handle record);

    int insertSelective(Handle record);

    Handle selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(Handle record);

    int updateByPrimaryKey(Handle record);
}