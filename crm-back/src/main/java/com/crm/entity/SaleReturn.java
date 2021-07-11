package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (SaleReturn)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class SaleReturn implements Serializable {
    private static final long serialVersionUID = 417924972195654133L;

    private Integer saleReturnId;

    private Integer saleOrderId;

    private Integer empId;

    private Integer customerId;

    private String saleReturnName;

    private Date returnDate;

    private Double returnAmount;

    private String returnMethod;

    private String returnCause;

    private String returnRemark;


    public Integer getSaleReturnId() {
        return saleReturnId;
    }

    public void setSaleReturnId(Integer saleReturnId) {
        this.saleReturnId = saleReturnId;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getSaleReturnName() {
        return saleReturnName;
    }

    public void setSaleReturnName(String saleReturnName) {
        this.saleReturnName = saleReturnName;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Double getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Double returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnMethod() {
        return returnMethod;
    }

    public void setReturnMethod(String returnMethod) {
        this.returnMethod = returnMethod;
    }

    public String getReturnCause() {
        return returnCause;
    }

    public void setReturnCause(String returnCause) {
        this.returnCause = returnCause;
    }

    public String getReturnRemark() {
        return returnRemark;
    }

    public void setReturnRemark(String returnRemark) {
        this.returnRemark = returnRemark;
    }

}
