package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (Receipt)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Receipt implements Serializable {
    private static final long serialVersionUID = -54965752138827853L;

    private Integer receiptId;

    private Integer collectionId;

    private Integer empId;

    private String receiptName;

    private BigDecimal receiptMoney;

    private String billTitle;

    private String payTaxes;

    private String remarks;
}
