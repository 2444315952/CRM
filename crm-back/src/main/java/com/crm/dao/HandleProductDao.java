package com.crm.dao;

import com.crm.entity.HandleProduct;
import org.apache.ibatis.annotations.Mapper;

//出入库单明细的dao层
@Mapper
public interface HandleProductDao {
    int deleteByPrimaryKey(Integer handleProductId);

    int insert(HandleProduct record);

    int insertSelective(HandleProduct record);

    HandleProduct selectByPrimaryKey(Integer handleProductId);

    int updateByPrimaryKeySelective(HandleProduct record);

    int updateByPrimaryKey(HandleProduct record);
}