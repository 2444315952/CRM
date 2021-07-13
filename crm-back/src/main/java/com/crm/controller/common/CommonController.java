package com.crm.controller.common;

import com.crm.service.CommonService;
import com.crm.vo.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("common")
public class CommonController {

    /**
     * 服务对象
     */
    @Resource
    private CommonService commonService;

    /**
     * 查询所有客户
     * @return 实例对象
     */
    @GetMapping("customer")
    public AjaxResponse queryAllCustomer(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.commonService.queryAllCustomer(pageNum, pageSize));
    }

    /**
     * 查询所有产品
     * @return 实例对象
     */
    @GetMapping("product")
    public AjaxResponse queryAllProduct(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.commonService.queryAllProduct(pageNum, pageSize));
    }
}
