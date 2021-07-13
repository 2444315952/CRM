package com.crm.controller;


import com.crm.service.FollowService;
import com.crm.vo.AjaxResponse;
import com.crm.vo.FollowPlanVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * (Follow)表控制层
 *
 * @author makejava
 * @since 2021-07-11 15:03:16
 */
@RestController
@RequestMapping("follow")
public class FollowController {
    /**
     * 服务对象
     */
    @Resource
    private FollowService followService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("selectAllFollow")
    public List<FollowPlanVo> selectAllFollow(FollowPlanVo followPlanVo) {
        return this.followService.selectAllFollow();
    }

    @GetMapping("selectAllRecord")
    public List<FollowPlanVo> selectAllRecord(FollowPlanVo followPlanVo) {
        return this.followService.selectAllRecord();
    }
    /**
     * 新增
     */
    @PostMapping("/addFollow")
    public AjaxResponse addFollow(@RequestBody @Valid FollowPlanVo followPlanVo){
        followService.addFollow(followPlanVo);
        return AjaxResponse.success(followPlanVo);
    }
    /**
     * 删除
     */
    @DeleteMapping("/delFollowById")
    public String delFollowById(@PathVariable("id") int id){
        followService.deleteById(id);
        return "ok";
    }
    @PutMapping("/updateRecprd")
    public AjaxResponse updateRecprd(@RequestBody @Valid FollowPlanVo followPlanVo){
        followService.updateRecprd(followPlanVo);
        return AjaxResponse.success(followPlanVo);
    }
}