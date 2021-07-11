package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Clue)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class Clue implements Serializable {
    private static final long serialVersionUID = -15253700497968076L;

    private Integer activityId;

    private Integer clueId;

    private Integer publicpondId;

    private Integer empId;

    private String clueName;

    private String clueCompany;

    private String clueContacts;

    private String cluePhone;

    private Integer clueType;

    private Integer conversionType;


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
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

    public String getClueName() {
        return clueName;
    }

    public void setClueName(String clueName) {
        this.clueName = clueName;
    }

    public String getClueCompany() {
        return clueCompany;
    }

    public void setClueCompany(String clueCompany) {
        this.clueCompany = clueCompany;
    }

    public String getClueContacts() {
        return clueContacts;
    }

    public void setClueContacts(String clueContacts) {
        this.clueContacts = clueContacts;
    }

    public String getCluePhone() {
        return cluePhone;
    }

    public void setCluePhone(String cluePhone) {
        this.cluePhone = cluePhone;
    }

    public Integer getClueType() {
        return clueType;
    }

    public void setClueType(Integer clueType) {
        this.clueType = clueType;
    }

    public Integer getConversionType() {
        return conversionType;
    }

    public void setConversionType(Integer conversionType) {
        this.conversionType = conversionType;
    }

}
