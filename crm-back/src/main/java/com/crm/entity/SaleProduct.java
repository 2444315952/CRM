package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (SaleProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class SaleProduct implements Serializable {
    private static final long serialVersionUID = -61680932789177107L;

    private Integer saleProductId;

    private Integer saleOrderId;

    private Integer proId;


    public Integer getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(Integer saleProductId) {
        this.saleProductId = saleProductId;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

}
