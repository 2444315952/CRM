package com.crm.controller;

import com.crm.entity.Activity;
import com.crm.entity.Clue;
import com.crm.service.ClueService;
import com.crm.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class CLueController {
    @Resource
    private ClueService clueService;

    @PostMapping("/addClue")
    public AjaxResponse addClue(@RequestBody @Valid Clue clue){
        clueService.addClue(clue);
        return AjaxResponse.success(clue);
    }

    @PutMapping("/updateByClueKeySelective")
    public AjaxResponse updateByClueKeySelective(@RequestBody @Valid Clue clue){
        clueService.updateByClueKeySelective(clue);
        return AjaxResponse.success(clue);
    }

    @PutMapping("/deleteByClueKey")
    public AjaxResponse deleteByClueKey(@RequestBody @Valid Clue clue){
        clueService.deleteByClueKey(clue);
        return AjaxResponse.success(clue);
    }

    @GetMapping("/selectByClues")
    public List<Clue> selectByClues(){
        return clueService.selectByClues();
    }

    @GetMapping("/selectByCustomer")
    public List<Clue> selectByCustomer(){
        return clueService.selectByCustomer();
    }

    @GetMapping("/selectByMyClues")
    public List<Clue> selectByMyClues(){
        return clueService.selectByMyClues();
    }

    @GetMapping("/selectByMyCustomer")
    public List<Clue> selectByMyCustomer(){
        return clueService.selectByMyCustomer();
    }

    @GetMapping("/selectByContacts")
    public List<Clue> selectByContacts(){
        return clueService.selectByContacts();
    }

    @GetMapping("/selectByMyContacts")
    public List<Clue> selectByMyContacts(){
        return clueService.selectByMyContacts();
    }

    @PutMapping("/updateByConversion")
    public AjaxResponse updateByConversion(@RequestBody @Valid Clue clue){
        clueService.updateByConversion(clue);
        return AjaxResponse.success(clue);
    }

    @PutMapping("/TakeItByEmpName")
    public AjaxResponse TakeItByEmpName(@RequestBody @Valid Clue clue){
        clueService.TakeItByEmpName(clue);
        return AjaxResponse.success(clue);
    }


}
