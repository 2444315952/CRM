package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (CollectionPeriod)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class CollectionPeriod implements Serializable {
    private static final long serialVersionUID = -66661932459783414L;

    private Integer collectionId;

    private Integer empId;

    private String beriodName;

    private Double blannedMoeny;

    private Date blannedDate;

    private String remarks;

    private Double bmountMoeny;

    private Double billing;


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

    public String getBeriodName() {
        return beriodName;
    }

    public void setBeriodName(String beriodName) {
        this.beriodName = beriodName;
    }

    public Double getBlannedMoeny() {
        return blannedMoeny;
    }

    public void setBlannedMoeny(Double blannedMoeny) {
        this.blannedMoeny = blannedMoeny;
    }

    public Date getBlannedDate() {
        return blannedDate;
    }

    public void setBlannedDate(Date blannedDate) {
        this.blannedDate = blannedDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getBmountMoeny() {
        return bmountMoeny;
    }

    public void setBmountMoeny(Double bmountMoeny) {
        this.bmountMoeny = bmountMoeny;
    }

    public Double getBilling() {
        return billing;
    }

    public void setBilling(Double billing) {
        this.billing = billing;
    }

}
