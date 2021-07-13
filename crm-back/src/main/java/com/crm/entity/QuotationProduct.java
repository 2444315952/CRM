package com.crm.entity;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (QuotationProduct)实体类
 *
 * @author makejava
 * @since 2021-07-12 20:48:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuotationProduct {

    private Integer quotationProductId;

    private Integer quotationId;

    private Integer proId;

    private BigDecimal unitPrice;

    private Integer quantity;

    private BigDecimal subtotal;
}
