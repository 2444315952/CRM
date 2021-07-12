package com.crm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.CollectionPeriod;
import com.crm.service.CollectionPeriodService;
import com.crm.vo.AjaxResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
        return AjaxResponse.success("新增回款期次成功！");
    }
    //查询回款及收入中的【订单汇总】
    @GetMapping("selectorderandperiodAll")
    public AjaxResponse selectorderandperiodAll(){
        return AjaxResponse.success(this.collectionPeriodService.selectorderandperiodAll());
    }
}
