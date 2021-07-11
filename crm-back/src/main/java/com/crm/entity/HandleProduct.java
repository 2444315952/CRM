package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (HandleProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class HandleProduct implements Serializable {
    private static final long serialVersionUID = -46000505966214482L;

    private Integer handleProductId;

    private Integer proId;

    private Integer hid;

    private Integer handNum;


    public Integer getHandleProductId() {
        return handleProductId;
    }

    public void setHandleProductId(Integer handleProductId) {
        this.handleProductId = handleProductId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getHandNum() {
        return handNum;
    }

    public void setHandNum(Integer handNum) {
        this.handNum = handNum;
    }

}
