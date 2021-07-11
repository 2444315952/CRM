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
 * @since 2021-07-11 17:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HandleProduct implements Serializable {
    private static final long serialVersionUID = 780495895042856823L;

    private Integer handleProductId;

    private Integer proId;

    private Integer hid;

    private Integer handNum;
}
