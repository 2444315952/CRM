package com.crm.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

@Data
/**
 * (Activity)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = 834017473749501246L;

    private Integer activityId;

    private Integer empId;

    private String activityName;

    private Date addTime;

    private Date endTime;

    private String address;

    private Integer activityType;

    private Integer activityState;

    private Double planincome;

    private Double actualincome;

    private Double profitloss;

    private String activityPlan;


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Double getPlanincome() {
        return planincome;
    }

    public void setPlanincome(Double planincome) {
        this.planincome = planincome;
    }

    public Double getActualincome() {
        return actualincome;
    }

    public void setActualincome(Double actualincome) {
        this.actualincome = actualincome;
    }

    public Double getProfitloss() {
        return profitloss;
    }

    public void setProfitloss(Double profitloss) {
        this.profitloss = profitloss;
    }

    public String getActivityPlan() {
        return activityPlan;
    }

    public void setActivityPlan(String activityPlan) {
        this.activityPlan = activityPlan;
    }

}
