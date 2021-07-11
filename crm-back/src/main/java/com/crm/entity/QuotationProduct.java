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
 * @since 2021-07-11 14:45:31
 */
@AllArgsConstructor
@Data
public class QuotationProduct implements Serializable {
    private static final long serialVersionUID = -55055537032331199L;

    private Integer quotationProductId;

    private Integer quotationId;

    private Integer proId;
}
