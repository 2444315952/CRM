package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (SaleContract)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class SaleContract implements Serializable {
    private static final long serialVersionUID = 222911046149977429L;

    private Integer saleContractId;

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private String contractName;

    private Date contractDate;

    private String contractSate;

    private Date startDate;

    private Date endDate;


    public Integer getSaleContractId() {
        return saleContractId;
    }

    public void setSaleContractId(Integer saleContractId) {
        this.saleContractId = saleContractId;
    }

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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractSate() {
        return contractSate;
    }

    public void setContractSate(String contractSate) {
        this.contractSate = contractSate;
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

}
