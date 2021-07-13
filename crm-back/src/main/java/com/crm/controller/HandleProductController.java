package com.crm.controller;

import com.crm.service.HandleProductService;
import com.crm.vo.AjaxResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 出入库单明细控制层
 */
@RestController
@RequestMapping("/handlePro")
public class HandleProductController {
    @Autowired
    private HandleProductService handleProductService;

    /**
     * 查询出入库单下所有的产品明细记录
     */
    @GetMapping
    public AjaxResponse findAllHandleProduct(int size,int page){
        PageInfo<Map> allHandleProduct = handleProductService.findAllHandleProduct(page, size);
        return AjaxResponse.success(allHandleProduct);
    }
}
