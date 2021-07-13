package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import lombok.ToString;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:27
 * @since 2021-07-11 17:51:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 730654864761359122L;

    private Integer empId;

    private String empName;

    private String empPhone;

    private String empPwd;

    private Integer empQuantity;

    private Integer timeliness;
}
