package com.crm.controller;

import com.crm.entity.TaskEmp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/demo")
    public String demo(@RequestParam(defaultValue = "a") String a){
        TaskEmp taskEmp = new TaskEmp(1,1,1);
        System.out.println(a) ;
        return "hello would";
    }
}
