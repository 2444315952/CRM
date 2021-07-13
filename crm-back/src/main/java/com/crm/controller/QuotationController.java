package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.Quotation;
import com.crm.service.QuotationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Quotation)表控制层
 *
 * @author makejava
 * @since 2021-07-14 04:26:18
 */
@RestController
public class QuotationController {
    /**
     * 服务对象
     */
    @Resource
    private QuotationService quotationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/quotation/one")
    public Quotation selectOne(Integer id) {
        return this.quotationService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/quotation")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.quotationService.queryAll(pageNum, pageSize));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param quotation
     * @return 对象列表
     */
    @GetMapping("/quotation/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, Quotation quotation) {
        return AjaxResponse.success(this.quotationService.queryBySearch(quotation, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param quotation
     * @return 对象列表
     */
    @GetMapping("/quotation/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, Quotation quotation) {
        return AjaxResponse.success(this.quotationService.queryByScreen(quotation, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    @PostMapping("/quotation")
    public AjaxResponse insert(@RequestBody Quotation quotation) {
        return AjaxResponse.success(this.quotationService.insert(quotation));
    }

    /**
     * 批量新增数据
     *
     * @param QuotationList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/quotation/batch")
    public AjaxResponse insertBatch(@RequestBody List<Quotation> QuotationList) {
        return AjaxResponse.success(this.quotationService.insertBatch(QuotationList));
    }

    /**
     * 修改数据
     *
     * @param quotation 实例对象
     * @return 实例对象
     */
    @PutMapping("/quotation")
    public AjaxResponse update(@RequestBody Quotation quotation) {
        return AjaxResponse.success(this.quotationService.update(quotation));
    }

    /**
     * 批量修改数据
     *
     * @param quotationList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/quotation/batch")
    public AjaxResponse updateBatch(@RequestBody List<Quotation> quotationList) {
        return AjaxResponse.success(this.quotationService.updateBatch(quotationList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/quotation")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.quotationService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/quotation/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.quotationService.deleteBatch(ids));
    }
}
