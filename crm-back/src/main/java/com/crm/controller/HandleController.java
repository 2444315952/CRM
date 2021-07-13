package com.crm.controller;

import com.crm.entity.Handle;
import com.crm.exception.CustomError;
import com.crm.exception.CustomErrorType;
import com.crm.service.HandleService;
import com.crm.service.impl.HandleService;
import com.crm.vo.AjaxResponse;
import com.crm.vo.HandleReq;
import com.crm.vo.OutInStoreBillReq;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 根据出入库表的id删除出入库单的数据，和出入库明细表的数据
     */
    @DeleteMapping("/{hId}")
    public AjaxResponse delInOutStoreBill(@PathVariable int hId){
        System.out.println(hId);
        int i = handleService.delOutInStoreBillAndDes(hId);
        return i>0?AjaxResponse.success():AjaxResponse.error(new CustomError(CustomErrorType.USER_INPUT_ERROR,"删除失败"));
    }

    /**
     * 查询未办理的出入库单
     */
    @GetMapping
    public AjaxResponse findIfHandlerOInStore(){
        List<Map> outInStores = handleService.findIfHandlerOInStore();
        return AjaxResponse.success(outInStores);
    }

    /**
     * 查询所有的出入库单的记录
     */
    @GetMapping("/all")
    public AjaxResponse findAllHandle(int size,int page){
        PageInfo<Map> pageInfo = handleService.findAllHandle(size, page);
        return AjaxResponse.success(pageInfo);
    }

    /**
     * 添加出入库单记录
     */
    @PutMapping
    public AjaxResponse addOutInStoreBill(@RequestBody OutInStoreBillReq outInStoreBillReq){
        handleService.addOutInStoreBill(outInStoreBillReq);
        return AjaxResponse.success();
    }

    /**
     * 对未办理的出入库单进行办理
     */
    @PostMapping
    public AjaxResponse updateHandle(@RequestBody HandleReq handleReq){
        System.out.println(handleReq);
        int i = handleService.updateHandle(handleReq);
        if(i>0){
            return AjaxResponse.success();
        }else if(i<0){
            return AjaxResponse.error(new CustomError(CustomErrorType.USER_INPUT_ERROR,"库存不足"));
        }else{
            return AjaxResponse.error(new CustomError(CustomErrorType.USER_INPUT_ERROR,"办理失败"));
        }
    }
}
