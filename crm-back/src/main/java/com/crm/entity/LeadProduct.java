package com.crm.entity;

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
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LeadProduct implements Serializable {
    private static final long serialVersionUID = -27829928537971115L;

    private Integer leadProductId;

    private Integer proId;

    private Integer leadId;
}
