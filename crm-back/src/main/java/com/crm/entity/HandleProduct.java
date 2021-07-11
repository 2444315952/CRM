package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (HandleProduct)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:29
 */
@AllArgsConstructor
@Data
public class HandleProduct implements Serializable {
    private static final long serialVersionUID = -54144300619572176L;

    private Integer handleProductId;

    private Integer proId;

    private Integer hid;

    private Integer handNum;
}
