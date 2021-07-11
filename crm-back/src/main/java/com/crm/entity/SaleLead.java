package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (SaleLead)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class SaleLead implements Serializable {
    private static final long serialVersionUID = 855620324780287087L;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private Integer activityId;

    private String leadName;

    private Double leadAmount;

    private Date transactionDate;

    private String leadStage;

    private String leadType;

    private String leadSource;

    private String leadRemark;


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

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public Double getLeadAmount() {
        return leadAmount;
    }

    public void setLeadAmount(Double leadAmount) {
        this.leadAmount = leadAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getLeadStage() {
        return leadStage;
    }

    public void setLeadStage(String leadStage) {
        this.leadStage = leadStage;
    }

    public String getLeadType() {
        return leadType;
    }

    public void setLeadType(String leadType) {
        this.leadType = leadType;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getLeadRemark() {
        return leadRemark;
    }

    public void setLeadRemark(String leadRemark) {
        this.leadRemark = leadRemark;
    }

}
