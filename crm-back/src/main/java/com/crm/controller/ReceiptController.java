package com.crm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.Receipt;
import com.crm.service.ReceiptService;
import com.crm.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Receipt)表控制层
 *
 * @author makejava
 * @since 2021-07-12 08:58:50
 */
@RestController
@RequestMapping("receipt")
public class ReceiptController {
    /**
     * 服务对象
     */
    @Resource
    private ReceiptService receiptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Receipt selectOne(Integer id) {
        return this.receiptService.queryById(id);
    }

    //新增一条开票申请
    @PostMapping("addReceipt")
    public AjaxResponse addReceipt(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String pece = jsonObject.getString("receipt");
        Receipt receipt = JSON.parseObject(pece,Receipt.class);
        return AjaxResponse.success("新增成功！");
    }
}
