package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (QuotationProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:20
 */
public class QuotationProduct implements Serializable {
    private static final long serialVersionUID = 666102310893434012L;

    private Integer quotationProductId;

    private Integer quotationId;

    private Integer proId;


    public Integer getQuotationProductId() {
        return quotationProductId;
    }

    public void setQuotationProductId(Integer quotationProductId) {
        this.quotationProductId = quotationProductId;
    }

    public Integer getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

}
