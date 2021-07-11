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
 * @since 2021-07-11 14:24:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReturnProduct implements Serializable {
    private static final long serialVersionUID = 122397266473173903L;

    private Integer returnProductId;

    private Integer proId;

    private Integer saleReturnId;
}
