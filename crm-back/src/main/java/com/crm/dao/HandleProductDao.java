package com.crm.dao;

import com.crm.entity.HandleProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//出入库单明细的dao层
@Mapper
public interface HandleProductDao {
    List<Map> findAllHandleProduct();

}