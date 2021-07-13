package com.crm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.Receipt;
import com.crm.service.ReceiptService;
import com.crm.vo.AjaxResponse;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        this.receiptService.insert(receipt);
        return AjaxResponse.success("新增成功！");
    }
    //根据期次id查询该期次的开票申请
    @GetMapping("queryreceipt")
    public AjaxResponse queryreceipt(int id){
        return AjaxResponse.success(this.receiptService.queryreceipt(id));
    }
    //根据票据id将该单据状态改为已审批
    @GetMapping("updatereceiptasone")
    public AjaxResponse updatereceiptasone(int id){
        this.receiptService.updatesreceiptone(id);
        return AjaxResponse.success("审批通过!");
    }
    //根据票据id将该单据状态改为已驳回
    @GetMapping("updatereceiptastwo")
    public AjaxResponse updatereceiptastwo(int id){
        this.receiptService.updatesreceipttwo(id);
        return AjaxResponse.success("已驳回!");
    }
    //查询所有发票记录
    @GetMapping("selectallreceipt")
    public AjaxResponse selectallreceipt(String activeName){
        if(activeName.equals("first")){
            return AjaxResponse.success(this.receiptService.selectReceipt());
        }else if(activeName.equals("second")){
            return AjaxResponse.success(this.receiptService.selectReceiptapplyone());
        }else{
            return AjaxResponse.success(this.receiptService.selectReceiptapplytwo());
        }
    }

    //将选择的单据批量修改为已审批状态
    @PostMapping("updatespltg")
    public AjaxResponse updatespltg(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String x = jsonObject.getString("list");
        String str = x.substring(x.indexOf("[")+1,x.indexOf("]"));
        String[] id = str.split(",");
        for(int i = 0;i<id.length;i++){
              this.receiptService.updatesreceiptone(Integer.parseInt(id[i]));
        }
        return AjaxResponse.success("审批成功！");
    }
    //将选择的单据批量修改为待审批状态
    @PostMapping("updatesplcx")
    public AjaxResponse updatesplcx(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String x = jsonObject.getString("list");
        String str = x.substring(x.indexOf("[")+1,x.indexOf("]"));
        String[] id = str.split(",");
        for(int i = 0;i<id.length;i++){
            this.receiptService.updatesreceiptzero(Integer.parseInt(id[i]));
        }
        return AjaxResponse.success("撤销驳回成功！");
    }
    //将选择的单据批量修改为驳回状态
    @PostMapping("updatesplbh")
    public AjaxResponse updatesplbh(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String x = jsonObject.getString("list");
        String str = x.substring(x.indexOf("[")+1,x.indexOf("]"));
        String[] id = str.split(",");
        for(int i = 0;i<id.length;i++){
            this.receiptService.updatesreceipttwo(Integer.parseInt(id[i]));
        }
        return AjaxResponse.success("驳回成功！");
    }
}
