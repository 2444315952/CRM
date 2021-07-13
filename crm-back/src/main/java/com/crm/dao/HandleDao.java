package com.crm.dao;


import com.crm.entity.Handle;
import com.crm.entity.Product;
import com.crm.vo.HandleReq;
import com.crm.vo.OutInStoreBillReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//出入库办理的dao层
@Mapper
//@Component
public interface HandleDao {
    //查询未办理的出入库单
    List<Map> findIfHandlerOInStore();
    //查询所有的出入库单总产品数量记录
    List<Map> findAllHandle();
    //添加一条出入库单记录
    int addOutInStoreBill(OutInStoreBillReq outInStoreBillReq);
    //添加一条出库单明细记录
    int addOutInStoreBillDes(OutInStoreBillReq outInStoreBillReq);
    //增加产品的库存数量
    int addProNum(int proId,int proNum);
    //减少产品数量
    int reduceProNum(int proId,int proNum);

    //查询新增加的出入库单生成的主键id值
    Handle findHandle();
    //对未办理的出入库单进行办理
    int updateHandle(HandleReq handleReq);
    //查询产品的库存数量
    Product findProNum(int proId);
    //根据出入库表的id删除出入库单表的记录
    int delOutInStoreBill(int hId);
    //根据出入库表的id删除出入库明细表的记录
    int delOutInStoreBillDes(int hId);

}