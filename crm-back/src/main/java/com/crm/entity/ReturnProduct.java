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
 * @since 2021-07-11 17:51:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnProduct implements Serializable {
    private static final long serialVersionUID = -50947242495897027L;

    private Integer returnProductId;

    private Integer proId;

    private Integer saleReturnId;
}
