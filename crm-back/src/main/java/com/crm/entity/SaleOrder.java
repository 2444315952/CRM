package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (SaleOrder)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class SaleOrder implements Serializable {
    private static final long serialVersionUID = -61783965210280712L;

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private Integer activityId;

    private String saleOrderName;

    private Double saleOrderAmount;

    private Date transactionDate;

    private Date startDate;

    private Date endDate;

    private String paymentMothod;

    private String saleOrderState;

    private String saleOrderRemark;


    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getSaleOrderName() {
        return saleOrderName;
    }

    public void setSaleOrderName(String saleOrderName) {
        this.saleOrderName = saleOrderName;
    }

    public Double getSaleOrderAmount() {
        return saleOrderAmount;
    }

    public void setSaleOrderAmount(Double saleOrderAmount) {
        this.saleOrderAmount = saleOrderAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPaymentMothod() {
        return paymentMothod;
    }

    public void setPaymentMothod(String paymentMothod) {
        this.paymentMothod = paymentMothod;
    }

    public String getSaleOrderState() {
        return saleOrderState;
    }

    public void setSaleOrderState(String saleOrderState) {
        this.saleOrderState = saleOrderState;
    }

    public String getSaleOrderRemark() {
        return saleOrderRemark;
    }

    public void setSaleOrderRemark(String saleOrderRemark) {
        this.saleOrderRemark = saleOrderRemark;
    }

}
