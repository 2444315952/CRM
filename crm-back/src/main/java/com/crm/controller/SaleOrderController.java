package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.SaleOrder;
import com.crm.service.SaleOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleOrder)表控制层
 *
 * @author makejava
 * @since 2021-07-13 09:08:44
 */
@RestController
public class SaleOrderController {
    /**
     * 服务对象
     */
    @Resource
    private SaleOrderService saleOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/saleOrder/one")
    public SaleOrder selectOne(Integer id) {
        return this.saleOrderService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/saleOrder")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize,Integer leadId) {
        return AjaxResponse.success(this.saleOrderService.queryAll(pageNum, pageSize,leadId));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleOrder
     * @return 对象列表
     */
    @GetMapping("/saleOrder/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleOrder saleOrder) {
        return AjaxResponse.success(this.saleOrderService.queryBySearch(saleOrder, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleOrder
     * @return 对象列表
     */
    @GetMapping("/saleOrder/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleOrder saleOrder) {
        return AjaxResponse.success(this.saleOrderService.queryByScreen(saleOrder, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @PostMapping("/saleOrder")
    public AjaxResponse insert(@RequestBody SaleOrder saleOrder) {
        return AjaxResponse.success(this.saleOrderService.insert(saleOrder));
    }

    /**
     * 批量新增数据
     *
     * @param SaleOrderList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/saleOrder/batch")
    public AjaxResponse insertBatch(@RequestBody List<SaleOrder> SaleOrderList) {
        return AjaxResponse.success(this.saleOrderService.insertBatch(SaleOrderList));
    }

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @PutMapping("/saleOrder")
    public AjaxResponse update(@RequestBody SaleOrder saleOrder) {
        return AjaxResponse.success(this.saleOrderService.update(saleOrder));
    }

    /**
     * 批量修改数据
     *
     * @param saleOrderList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/saleOrder/batch")
    public AjaxResponse updateBatch(@RequestBody List<SaleOrder> saleOrderList) {
        return AjaxResponse.success(this.saleOrderService.updateBatch(saleOrderList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/saleOrder")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.saleOrderService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/saleOrder/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.saleOrderService.deleteBatch(ids));
    }
}
