package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (ReturnProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReturnProduct implements Serializable {
    private static final long serialVersionUID = 393193605447044351L;

    private Integer íë»õµ¥²úæ·id

    private Integer proId;

    private Integer saleReturnId;
}
