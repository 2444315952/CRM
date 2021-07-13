package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.SaleLead;
import com.crm.service.SaleLeadService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleLead)表控制层
 *
 * @author makejava
 * @since 2021-07-11 17:10:16
 */
@RestController
public class SaleLeadController {
    /**
     * 服务对象
     */
    @Resource
    private SaleLeadService saleLeadService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/saleLead/one")
    public SaleLead selectOne(Integer id) {
        return this.saleLeadService.queryById(id);
    }

    /**
     * 查询所有数据
     * @return 实例对象
     */
    @GetMapping("/saleLead")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        return AjaxResponse.success(this.saleLeadService.queryAll(pageNum, pageSize));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleLead
     * @return 对象列表
     */
    @GetMapping("/saleLead/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleLead saleLead) {
        return AjaxResponse.success(this.saleLeadService.queryBySearch(saleLead, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleLead
     * @return 对象列表
     */
    @GetMapping("/saleLead/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleLead saleLead) {
        return AjaxResponse.success(this.saleLeadService.queryByScreen(saleLead, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    @PostMapping("/saleLead")
    public AjaxResponse insert(@RequestBody SaleLead saleLead) {
        return AjaxResponse.success(this.saleLeadService.insert(saleLead));
    }

    /**
     * 批量新增数据
     *
     * @param SaleLeadList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/saleLead/batch")
    public AjaxResponse insertBatch(@RequestBody List<SaleLead> SaleLeadList) {
        return AjaxResponse.success(this.saleLeadService.insertBatch(SaleLeadList));
    }

    /**
     * 修改数据
     *
     * @param saleLead 实例对象
     * @return 实例对象
     */
    @PutMapping("/saleLead")
    public AjaxResponse update(@RequestBody SaleLead saleLead) {
        return AjaxResponse.success(this.saleLeadService.update(saleLead));
    }

    /**
     * 批量修改数据
     *
     * @param saleLeadList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/saleLead/batch")
    public AjaxResponse updateBatch(@RequestBody List<SaleLead> saleLeadList) {
        return AjaxResponse.success(this.saleLeadService.updateBatch(saleLeadList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/saleLead")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.saleLeadService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/saleLead/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.saleLeadService.deleteBatch(ids));
    }
}
