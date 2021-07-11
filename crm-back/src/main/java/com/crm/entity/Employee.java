package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee implements Serializable {
    private static final long serialVersionUID = 597883917578471953L;

    private Integer empId;

    private String empName;

    private String empPhone;

    private String empPwd;

    private Integer empQuantity;
}
