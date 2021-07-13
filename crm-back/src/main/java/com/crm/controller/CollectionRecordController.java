package com.crm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.CollectionRecord;
import com.crm.service.CollectionRecordService;
import com.crm.vo.AjaxResponse;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CollectionRecord)表控制层
 *
 * @author makejava
 * @since 2021-07-11 18:53:38
 */
@RestController
@RequestMapping("collectionRecord")
public class CollectionRecordController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionRecordService collectionRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CollectionRecord selectOne(Integer id) {
        return this.collectionRecordService.queryById(id);
    }

    //新增一条回款记录
    @PostMapping("addRecord")
    public AjaxResponse addRecord(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String pd = jsonObject.getString("record");
        CollectionRecord collectionRecord = JSON.parseObject(pd,CollectionRecord.class);
        this.collectionRecordService.insert(collectionRecord);
        return AjaxResponse.success("新增成功回款记录成功！");
    }
    @GetMapping("deleterecord")
    public AjaxResponse delRecord(int id){
        this.collectionRecordService.deleteById(id);
        return AjaxResponse.success("删除成功！");
    }
}
