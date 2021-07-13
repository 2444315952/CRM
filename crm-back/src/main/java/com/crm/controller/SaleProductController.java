package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.SaleProduct;
import com.crm.service.SaleProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleProduct)表控制层
 *
 * @author makejava
 * @since 2021-07-12 21:46:33
 */
@RestController
public class SaleProductController {
    /**
     * 服务对象
     */
    @Resource
    private SaleProductService saleProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/saleProduct/one")
    public SaleProduct selectOne(Integer id) {
        return this.saleProductService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/saleProduct")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.saleProductService.queryAll(pageNum, pageSize));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleProduct
     * @return 对象列表
     */
    @GetMapping("/saleProduct/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleProduct saleProduct) {
        return AjaxResponse.success(this.saleProductService.queryBySearch(saleProduct, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleProduct
     * @return 对象列表
     */
    @GetMapping("/saleProduct/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleProduct saleProduct) {
        return AjaxResponse.success(this.saleProductService.queryByScreen(saleProduct, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    @PostMapping("/saleProduct")
    public AjaxResponse insert(@RequestBody SaleProduct saleProduct) {
        return AjaxResponse.success(this.saleProductService.insert(saleProduct));
    }

    /**
     * 批量新增数据
     *
     * @param SaleProductList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/saleProduct/batch")
    public AjaxResponse insertBatch(@RequestBody List<SaleProduct> SaleProductList) {
        return AjaxResponse.success(this.saleProductService.insertBatch(SaleProductList));
    }

    /**
     * 修改数据
     *
     * @param saleProduct 实例对象
     * @return 实例对象
     */
    @PutMapping("/saleProduct")
    public AjaxResponse update(@RequestBody SaleProduct saleProduct) {
        return AjaxResponse.success(this.saleProductService.update(saleProduct));
    }

    /**
     * 批量修改数据
     *
     * @param saleProductList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/saleProduct/batch")
    public AjaxResponse updateBatch(@RequestBody List<SaleProduct> saleProductList) {
        return AjaxResponse.success(this.saleProductService.updateBatch(saleProductList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/saleProduct")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.saleProductService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/saleProduct/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.saleProductService.deleteBatch(ids));
    }
}
