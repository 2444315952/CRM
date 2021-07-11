package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Quotation)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class Quotation implements Serializable {
    private static final long serialVersionUID = -67815367647589770L;

    private Integer quotationId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private String quotationName;

    private String quotationStage;

    private Double quotationAmount;

    private Date effectiveDate;

    private Date quotationDate;

    private String quotationRemark;


    public Integer getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
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

    public String getQuotationName() {
        return quotationName;
    }

    public void setQuotationName(String quotationName) {
        this.quotationName = quotationName;
    }

    public String getQuotationStage() {
        return quotationStage;
    }

    public void setQuotationStage(String quotationStage) {
        this.quotationStage = quotationStage;
    }

    public Double getQuotationAmount() {
        return quotationAmount;
    }

    public void setQuotationAmount(Double quotationAmount) {
        this.quotationAmount = quotationAmount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public String getQuotationRemark() {
        return quotationRemark;
    }

    public void setQuotationRemark(String quotationRemark) {
        this.quotationRemark = quotationRemark;
    }

}
