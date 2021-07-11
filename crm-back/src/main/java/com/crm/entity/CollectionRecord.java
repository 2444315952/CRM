package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (CollectionRecord)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class CollectionRecord implements Serializable {
    private static final long serialVersionUID = -54373628623505325L;

    private Integer collectionId;

    private Integer recordId;

    private Integer recordStaticId;

    private Integer empId;

    private Double paymentMoney;

    private Date paymentDate;

    private String paymentMode;

    private String remarks;


    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordStaticId() {
        return recordStaticId;
    }

    public void setRecordStaticId(Integer recordStaticId) {
        this.recordStaticId = recordStaticId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Double getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(Double paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
