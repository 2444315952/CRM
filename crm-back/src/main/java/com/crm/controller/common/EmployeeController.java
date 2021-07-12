package com.crm.controller.common;

import com.crm.vo.AjaxResponse;
import com.crm.entity.Employee;
import com.crm.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2021-07-11 17:10:15
 */
@RestController
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/employee/one")
    public Employee selectOne(Integer id) {
        return this.employeeService.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @GetMapping("/employee")
    public AjaxResponse queryAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize, Employee employee) {
        return AjaxResponse.success(this.employeeService.queryAll(employee, pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @PostMapping("/employee")
    public AjaxResponse insert(@RequestBody Employee employee) {
        return AjaxResponse.success(this.employeeService.insert(employee));
    }

    /**
     * 登录验证
     * @param employee(用户名，密码)
     * @return
     */
    @PostMapping("login")
    public AjaxResponse loginAuth(@RequestBody Employee employee) {
        return AjaxResponse.data(this.employeeService.loginAuth(employee.getEmpName(),employee.getEmpPwd()));
    }

}
