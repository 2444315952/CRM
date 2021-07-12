package com.crm.service.impl;

import com.crm.entity.Employee;
import com.crm.dao.EmployeeDao;
import com.crm.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 16:47:33
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param empId 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer empId) {
        return this.employeeDao.queryById(empId);
    }

    /**
     * 查询所有数据
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    @Override
    public PageInfo<Employee> queryAll(Employee employee, Integer pageNum, Integer pageSize) {
        Page<Employee> page = PageHelper.startPage(pageNum, pageSize);
        List<Employee> employeeList = this.employeeDao.queryAll(employee);
        return new PageInfo<>(employeeList);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee insert(Employee employee) {
        this.employeeDao.insert(employee);
        return this.queryById(employee.getEmpId());
    }

    /**
     * 登录验证
     * @param empName
     * @param empPwd
     * @return
     */
    @Override
    public Employee loginAuth(String empName, String empPwd) {
        return this.employeeDao.loginAuth(empName,empPwd);
    }

}
