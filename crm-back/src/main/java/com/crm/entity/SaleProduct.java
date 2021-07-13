package com.crm.entity;

import java.math.BigDecimal;
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
 * @since 2021-07-12 20:48:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleProduct {

    private Integer saleProductId;

    private Integer saleOrderId;

    private Integer proId;

    private BigDecimal unitPrice;

    private Integer quantity;

    private BigDecimal subtotal;
}
