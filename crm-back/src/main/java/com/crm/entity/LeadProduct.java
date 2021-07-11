package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (LeadProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class LeadProduct implements Serializable {
    private static final long serialVersionUID = -90355811715944005L;

    private Integer leadProductId;

    private Integer proId;

    private Integer leadId;


    public Integer getLeadProductId() {
        return leadProductId;
    }

    public void setLeadProductId(Integer leadProductId) {
        this.leadProductId = leadProductId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

}
