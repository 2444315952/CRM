package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (ReturnProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class ReturnProduct implements Serializable {
    private static final long serialVersionUID = -39108124590508972L;

    private Integer íë»õµ¥²úæ·id

    private Integer proId;

    private Integer saleReturnId;


    public Integer getÍë»õµ¥²úæ·

    id() {
        return íë»õµ¥²úæ·id;
    }

    public void setÍë»õµ¥²úæ·

    id(Integer íë»õµ¥²úæ·id) {
        this.íë»õµ¥²úæ·id = íë»õµ¥²úæ·id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getSaleReturnId() {
        return saleReturnId;
    }

    public void setSaleReturnId(Integer saleReturnId) {
        this.saleReturnId = saleReturnId;
    }

}
