package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (Receipt)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receipt implements Serializable {
    private static final long serialVersionUID = 192285276182611158L;

    private Integer receiptId;

    private Integer collectionId;

    private Integer empId;

    private String receiptName;

    private BigDecimal receiptMoney;

    private String billTitle;

    private String payTaxes;

    private String remarks;
}
