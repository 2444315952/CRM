package com.crm.controller;

import com.crm.entity.Follow;
import com.crm.service.FollowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Follow selectOne(Integer id) {
        return this.followService.queryById(id);
    }

}