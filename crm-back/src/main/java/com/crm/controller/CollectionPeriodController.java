package com.crm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.CollectionPeriod;
import com.crm.service.CollectionPeriodService;
import com.crm.vo.AjaxResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (CollectionPeriod)表控制层
 *
 * @author makejava
 * @since 2021-07-11 18:53:37
 */
@RestController
@RequestMapping("collectionPeriod")
public class CollectionPeriodController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionPeriodService collectionPeriodService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CollectionPeriod selectOne(Integer id) {
        return this.collectionPeriodService.queryById(id);
    }

    //新增一个回款期次
    @PostMapping("addPeriod")
    public AjaxResponse addPeriod(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String pd = jsonObject.getString("period");
        CollectionPeriod collectionPeriod = JSON.parseObject(pd,CollectionPeriod.class);
        this.collectionPeriodService.insert(collectionPeriod);
        return AjaxResponse.success("新增回款期次成功！");
    }
    //查询回款及收入中的【订单汇总】
    @GetMapping("selectorderandperiodAll")
    public AjaxResponse selectorderandperiodAll(){
        return AjaxResponse.success(this.collectionPeriodService.selectorderandperiodAll());
    }
    //根据订单查询他的回款期次
    @GetMapping("queryByorder_idas")
    public AjaxResponse queryByorder_idas(int id,Integer currenPage,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        JSONArray list = this.collectionPeriodService.queryByorder_idas(id);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //根据期次id查询该期次有多少条回款记录
    @GetMapping("queryByhuikjl")
    public AjaxResponse queryByhuikjl(int id){
        return AjaxResponse.success(this.collectionPeriodService.queryByhuikjl(id));
    }

    //查询选中订单的所有回款及本金
    @GetMapping("queryByOrderid_all")
    public AjaxResponse queryByOrderid_all(int id){
        Map<String,JSONArray> map =new HashMap<>();
        JSONArray js1 = this.collectionPeriodService.queryhkjeandorderje(id);
        JSONArray js2 = this.collectionPeriodService.querykpje(id);
        map.put("hkandod",js1);
        map.put("kp",js2);
        return AjaxResponse.success(map);
    }

    //查询订单汇总
    @GetMapping("selectorders")
    public AjaxResponse selectorders(Integer currenPage,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        JSONArray list = this.collectionPeriodService.selectorders();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}
