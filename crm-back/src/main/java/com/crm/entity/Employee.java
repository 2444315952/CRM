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
 * @since 2021-07-11 11:28:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee implements Serializable {
    private static final long serialVersionUID = -31655184462533310L;

    private Integer empId;

    private String empName;

    private String empPhone;

    private String empPwd;

    private Integer empQuantity;
}
