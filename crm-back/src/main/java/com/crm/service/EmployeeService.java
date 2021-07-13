package com.crm.service;

import com.crm.entity.Employee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 16:47:33
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param empId 主键
     * @return 实例对象
     */
    Employee queryById(Integer empId);

    /**
     * 查询所有数据
     * @return 实例对象
     */
    PageInfo<Employee> queryAll(Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 登录验证
     * @param empName
     * @param empPwd
     * @return
     */
    Employee loginAuth(String empName,String empPwd);
}
