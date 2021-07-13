package com.crm.service.impl;

import com.crm.dao.HandleDao;
import com.crm.entity.Handle;
import com.crm.entity.Product;
import com.crm.vo.HandleReq;
import com.crm.vo.OutInStoreBillReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HandleService {
    @Autowired
    @Resource
    private HandleDao handleDao;//出入库办理的dao层

    /**
     * 根据出入库表的id删除出入库单的记录和出入库明细表的记录
     */
    @Transactional
    public int delOutInStoreBillAndDes(int hId){
        //根据出入库表id删除出入库表的记录
        int i = handleDao.delOutInStoreBill(hId);
        //根据出入库表id删除出入库明细表的记录
        int i1 = handleDao.delOutInStoreBillDes(hId);
        return i>0&&i1>0?1:0;
    }

    /**
     * 查询未办理的出入库单
     */
    public List<Map> findIfHandlerOInStore(){
        return handleDao.findIfHandlerOInStore();
    }

    /**
     * 查询所有的出入库单的记录
     */
    public PageInfo<Map>  findAllHandle(int size,int page){
        PageHelper.startPage(page,size);
        List<Map> allHandle = handleDao.findAllHandle();
        return new PageInfo<>(allHandle);
    }

    /**
     * 增加产品的库存数量
     */
    public int addProNum(int proId,int proNum){
        return handleDao.addProNum(proId,proNum);
    }

    /**
     * 减少产品的库存数量
     */
    public int reduceProNum(int proId,int proNum){
        return handleDao.reduceProNum(proId,proNum);
    }

    //添加一条出库单明细记录
    public int addOutInStoreBillDes(OutInStoreBillReq outInStoreBillReq){
        Handle handle = handleDao.findHandle();
        outInStoreBillReq.setHId(handle.getHid());
        return handleDao.addOutInStoreBillDes(outInStoreBillReq);
    }
    /**
     *增加出入库单记录
     */
    @Transactional
    public int addOutInStoreBill(OutInStoreBillReq outInStorReq){
        String handStauts = outInStorReq.getHandStauts();
        String storeAction = outInStorReq.getStoreAction();
        int proId=outInStorReq.getProId();
        int outInStoreNum=outInStorReq.getOutInStoreNum();
        int i1=0;

        if(handStauts.equals("未办理")){
            outInStorReq.setHandDate(null);
        }
        int i = handleDao.addOutInStoreBill(outInStorReq);
        int i2= addOutInStoreBillDes(outInStorReq);

        if(handStauts.equals("已办理") && storeAction.equals("出库")){
            i1 = reduceProNum(proId, outInStoreNum);
            System.out.println(proId+"===出库数量"+outInStoreNum);
        }else if(handStauts.equals("已办理") && storeAction.equals("入库")){
            i1=addProNum(proId,outInStoreNum);
            System.out.println(proId+"===入库数量"+outInStoreNum);
        }
        return i>0&&i1>0&&i2>0?1:0;
    }

    /**
     * 对未办理的出库单进行办理
     */
    @Transactional
    public int updateHandle(HandleReq handleReq){

        //判断是否产品的库存充裕
        Product pro = handleDao.findProNum(handleReq.getProId());
        if(pro.getProNum()>handleReq.getSumNum()){
            //修改出入库单的办理状态
            int i = handleDao.updateHandle(handleReq);
            //修改产品的库存数量
            int i1 = handleDao.reduceProNum(handleReq.getProId(), handleReq.getSumNum());
            return i>0&&i1>0?1:0;
        }

        return -1;

    }
}
