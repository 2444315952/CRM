package com.crm.dao;

import com.crm.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 16:47:33
 */
@Mapper
public interface EmployeeDao {

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
    List<Employee> queryAll();

    /**
     * 登录验证
     * @param empName
     * @param empPwd
     * @return
     */
    Employee loginAuth(@Param("empName")String empName,@Param("empPwd")String empPwd);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee);
}

