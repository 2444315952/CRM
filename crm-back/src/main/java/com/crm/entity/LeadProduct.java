package com.crm.entity;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (LeadProduct)实体类
 *
 * @author makejava
 * @since 2021-07-12 21:51:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeadProduct {

    private Integer leadProductId;

    private Integer proId;

    private Integer leadId;

    private BigDecimal unitPrice;

    private Integer quantity;

    private BigDecimal subtotal;
}
