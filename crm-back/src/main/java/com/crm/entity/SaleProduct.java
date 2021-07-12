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
 * @since 2021-07-11 14:45:33
 * @since 2021-07-11 17:51:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleProduct implements Serializable {
    private static final long serialVersionUID = -99372214166813590L;
    private static final long serialVersionUID = 983232580422338769L;

    private Integer saleProductId;

    private Integer saleOrderId;

    private Integer proId;
}
