package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Receipt)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:20
 */
public class Receipt implements Serializable {
    private static final long serialVersionUID = -29665470809352375L;

    private Integer receiptId;

    private Integer collectionId;

    private Integer empId;

    private String receiptName;

    private Double receiptMoney;

    private String billTitle;

    private String payTaxes;

    private String remarks;


    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public Double getReceiptMoney() {
        return receiptMoney;
    }

    public void setReceiptMoney(Double receiptMoney) {
        this.receiptMoney = receiptMoney;
    }

    public String getBillTitle() {
        return billTitle;
    }

    public void setBillTitle(String billTitle) {
        this.billTitle = billTitle;
    }

    public String getPayTaxes() {
        return payTaxes;
    }

    public void setPayTaxes(String payTaxes) {
        this.payTaxes = payTaxes;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
