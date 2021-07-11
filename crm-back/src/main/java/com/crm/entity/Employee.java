package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 230821794718680620L;

    private Integer empId;

    private String empName;

    private String empPhone;

    private String empPwd;

    private Integer empQuantity;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public Integer getEmpQuantity() {
        return empQuantity;
    }

    public void setEmpQuantity(Integer empQuantity) {
        this.empQuantity = empQuantity;
    }

}
