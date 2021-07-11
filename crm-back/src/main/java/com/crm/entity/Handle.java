package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Handle)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class Handle implements Serializable {
    private static final long serialVersionUID = 424007552406580479L;

    private Integer hid;

    private String handId;

    private String handAction;

    private String handWay;

    private Integer billid;

    private Date createtime;

    private String handStauts;

    private Date handTime;

    private String handEmp;

    private Date handDate;

    private Integer sumNum;


    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHandId() {
        return handId;
    }

    public void setHandId(String handId) {
        this.handId = handId;
    }

    public String getHandAction() {
        return handAction;
    }

    public void setHandAction(String handAction) {
        this.handAction = handAction;
    }

    public String getHandWay() {
        return handWay;
    }

    public void setHandWay(String handWay) {
        this.handWay = handWay;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHandStauts() {
        return handStauts;
    }

    public void setHandStauts(String handStauts) {
        this.handStauts = handStauts;
    }

    public Date getHandTime() {
        return handTime;
    }

    public void setHandTime(Date handTime) {
        this.handTime = handTime;
    }

    public String getHandEmp() {
        return handEmp;
    }

    public void setHandEmp(String handEmp) {
        this.handEmp = handEmp;
    }

    public Date getHandDate() {
        return handDate;
    }

    public void setHandDate(Date handDate) {
        this.handDate = handDate;
    }

    public Integer getSumNum() {
        return sumNum;
    }

    public void setSumNum(Integer sumNum) {
        this.sumNum = sumNum;
    }

}
