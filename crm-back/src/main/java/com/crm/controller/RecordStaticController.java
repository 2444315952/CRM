package com.crm.controller;

import com.crm.entity.RecordStatic;
import com.crm.service.RecordStaticService;
import com.crm.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RecordStatic)表控制层
 *
 * @author makejava
 * @since 2021-07-12 18:41:19
 */
@RestController
@RequestMapping("recordStatic")
public class RecordStaticController {
    /**
     * 服务对象
     */
    @Resource
    private RecordStaticService recordStaticService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RecordStatic selectOne(Integer id) {
        return this.recordStaticService.queryById(id);
    }

    @GetMapping("queryalls")
    public AjaxResponse queryalls(){
        return AjaxResponse.success(this.recordStaticService.queryalls());
    }
}
