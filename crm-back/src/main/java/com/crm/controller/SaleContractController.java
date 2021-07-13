package com.crm.controller;

import com.crm.vo.AjaxResponse;
import com.crm.entity.SaleContract;
import com.crm.service.SaleContractService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (SaleContract)表控制层
 *
 * @author makejava
 * @since 2021-07-13 16:02:48
 */
@RestController
public class SaleContractController {
    /**
     * 服务对象
     */
    @Resource
    private SaleContractService saleContractService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/saleContract/one")
    public SaleContract selectOne(Integer id) {
        return this.saleContractService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @GetMapping("/saleContract")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize,Integer leadId) {
        return AjaxResponse.success(this.saleContractService.queryAll(pageNum, pageSize,leadId));
    }

    /**
     * 根据查询条件搜索数据
     *
     * @param saleContract
     * @return 对象列表
     */
    @GetMapping("/saleContract/search")
    public AjaxResponse queryBySearch(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleContract saleContract) {
        return AjaxResponse.success(this.saleContractService.queryBySearch(saleContract, pageNum, pageSize));
    }

    /**
     * 根据查询条件筛选数据
     *
     * @param saleContract
     * @return 对象列表
     */
    @GetMapping("/saleContract/screen")
    public AjaxResponse queryByScreen(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, SaleContract saleContract) {
        return AjaxResponse.success(this.saleContractService.queryByScreen(saleContract, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    @PostMapping("/saleContract")
    public AjaxResponse insert(@RequestBody SaleContract saleContract) {
        return AjaxResponse.success(this.saleContractService.insert(saleContract));
    }

    /**
     * 批量新增数据
     *
     * @param SaleContractList 实例对象列表
     * @return 影响行数
     */
    @PostMapping("/saleContract/batch")
    public AjaxResponse insertBatch(@RequestBody List<SaleContract> SaleContractList) {
        return AjaxResponse.success(this.saleContractService.insertBatch(SaleContractList));
    }

    /**
     * 修改数据
     *
     * @param saleContract 实例对象
     * @return 实例对象
     */
    @PutMapping("/saleContract")
    public AjaxResponse update(@RequestBody SaleContract saleContract) {
        return AjaxResponse.success(this.saleContractService.update(saleContract));
    }

    /**
     * 批量修改数据
     *
     * @param saleContractList 实例对象列表
     * @return 影响行数
     */
    @PutMapping("/saleContract/batch")
    public AjaxResponse updateBatch(@RequestBody List<SaleContract> saleContractList) {
        return AjaxResponse.success(this.saleContractService.updateBatch(saleContractList));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @DeleteMapping("/saleContract")
    public AjaxResponse deleteById(Integer id) {
        return AjaxResponse.success(this.saleContractService.deleteById(id));
    }

    /**
     * 批量删除数据
     *
     * @param ids 主键列表
     * @return 是否成功
     */
    @DeleteMapping("/saleContract/batch")
    public AjaxResponse deleteBatch(@RequestBody List<Integer> ids) {
        return AjaxResponse.success(this.saleContractService.deleteBatch(ids));
    }
}
