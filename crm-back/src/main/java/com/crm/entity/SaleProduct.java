package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (SaleProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleProduct implements Serializable {
    private static final long serialVersionUID = 925612915880174018L;

    private Integer saleProductId;

    private Integer saleOrderId;

    private Integer proId;
}
