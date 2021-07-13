package com.crm.controller;

import com.crm.service.impl.HandleService;
import com.crm.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 出入库办理的控制层
 */
@RestController
@RequestMapping("/handle")
public class HandleController {
    @Autowired
    private HandleService handleService;

    /**
     *
     * @return
     */
    @GetMapping
    public AjaxResponse findIfHandlerOInStore(){
        List<Map> outInStores = handleService.findIfHandlerOInStore();
        return AjaxResponse.success(outInStores);
    }
}
