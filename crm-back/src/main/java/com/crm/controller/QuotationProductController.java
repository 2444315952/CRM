package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.QuotationProduct;
import com.crm.service.QuotationProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (QuotationProduct)表控制层
 *
 * @author makejava
 * @since 2021-07-14 04:25:50
 */
@RestController
public class QuotationProductController {
    /**
     * 服务对象
     */
    @Resource
    private QuotationProductService quotationProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/quotationProduct/one")
    public QuotationProduct selectOne(Integer id) {
        return this.quotationProductService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/quotationProduct")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.quotationProductService.queryAll(pageNum, pageSize));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param quotationProduct
     * @return 对象列表
     */
    @GetMapping("/quotationProduct/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, QuotationProduct quotationProduct) {
        return AjaxResponse.success(this.quotationProductService.queryBySearch(quotationProduct, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param quotationProduct
     * @return 对象列表
     */
    @GetMapping("/quotationProduct/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, QuotationProduct quotationProduct) {
        return AjaxResponse.success(this.quotationProductService.queryByScreen(quotationProduct, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    @PostMapping("/quotationProduct")
    public AjaxResponse insert(@RequestBody QuotationProduct quotationProduct) {
        return AjaxResponse.success(this.quotationProductService.insert(quotationProduct));
    }

    /**
     * 批量新增数据
     *
     * @param QuotationProductList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/quotationProduct/batch")
    public AjaxResponse insertBatch(@RequestBody List<QuotationProduct> QuotationProductList) {
        return AjaxResponse.success(this.quotationProductService.insertBatch(QuotationProductList));
    }

    /**
     * 修改数据
     *
     * @param quotationProduct 实例对象
     * @return 实例对象
     */
    @PutMapping("/quotationProduct")
    public AjaxResponse update(@RequestBody QuotationProduct quotationProduct) {
        return AjaxResponse.success(this.quotationProductService.update(quotationProduct));
    }

    /**
     * 批量修改数据
     *
     * @param quotationProductList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/quotationProduct/batch")
    public AjaxResponse updateBatch(@RequestBody List<QuotationProduct> quotationProductList) {
        return AjaxResponse.success(this.quotationProductService.updateBatch(quotationProductList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/quotationProduct")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.quotationProductService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/quotationProduct/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.quotationProductService.deleteBatch(ids));
    }
}
