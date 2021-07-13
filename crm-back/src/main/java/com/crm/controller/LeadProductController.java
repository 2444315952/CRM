package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.LeadProduct;
import com.crm.service.LeadProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (LeadProduct)表控制层
 *
 * @author makejava
 * @since 2021-07-12 21:51:51
 */
@RestController
public class LeadProductController {
    /**
     * 服务对象
     */
    @Resource
    private LeadProductService leadProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/leadProduct/one")
    public LeadProduct selectOne(Integer id) {
        return this.leadProductService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/leadProduct")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.leadProductService.queryAll(pageNum, pageSize));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param leadProduct
     * @return 对象列表
     */
    @GetMapping("/leadProduct/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, LeadProduct leadProduct) {
        return AjaxResponse.success(this.leadProductService.queryBySearch(leadProduct, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param leadProduct
     * @return 对象列表
     */
    @GetMapping("/leadProduct/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, LeadProduct leadProduct) {
        return AjaxResponse.success(this.leadProductService.queryByScreen(leadProduct, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    @PostMapping("/leadProduct")
    public AjaxResponse insert(@RequestBody LeadProduct leadProduct) {
        return AjaxResponse.success(this.leadProductService.insert(leadProduct));
    }

    /**
     * 批量新增数据
     *
     * @param LeadProductList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/leadProduct/batch")
    public AjaxResponse insertBatch(@RequestBody List<LeadProduct> LeadProductList) {
        return AjaxResponse.success(this.leadProductService.insertBatch(LeadProductList));
    }

    /**
     * 修改数据
     *
     * @param leadProduct 实例对象
     * @return 实例对象
     */
    @PutMapping("/leadProduct")
    public AjaxResponse update(@RequestBody LeadProduct leadProduct) {
        return AjaxResponse.success(this.leadProductService.update(leadProduct));
    }

    /**
     * 批量修改数据
     *
     * @param leadProductList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/leadProduct/batch")
    public AjaxResponse updateBatch(@RequestBody List<LeadProduct> leadProductList) {
        return AjaxResponse.success(this.leadProductService.updateBatch(leadProductList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/leadProduct")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.leadProductService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/leadProduct/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.leadProductService.deleteBatch(ids));
    }
}
