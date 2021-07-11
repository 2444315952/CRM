package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 825456830224597142L;

    private Integer activityId;

    private Integer customerId;

    private Integer publicpondId;

    private Integer empId;

    private String customerName;

    private String customerCompany;

    private String customerContacts;

    private String customerPhone;

    private Integer customerType;


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPublicpondId() {
        return publicpondId;
    }

    public void setPublicpondId(Integer publicpondId) {
        this.publicpondId = publicpondId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getCustomerContacts() {
        return customerContacts;
    }

    public void setCustomerContacts(String customerContacts) {
        this.customerContacts = customerContacts;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

}
