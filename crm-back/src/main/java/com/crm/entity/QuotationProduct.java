package com.crm.entity;

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
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class QuotationProduct implements Serializable {
    private static final long serialVersionUID = -23662783002919652L;

    private Integer quotationProductId;

    private Integer quotationId;

    private Integer proId;
}
