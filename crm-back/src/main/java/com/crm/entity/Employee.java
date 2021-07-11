package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:27
 */
@AllArgsConstructor
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 730654864761359122L;

    private Integer empId;

    private String empName;

    private String empPhone;

    private String empPwd;

    private Integer empQuantity;
}
