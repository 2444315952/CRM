package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 453447387348206933L;

    private Integer proId;

    private Integer empId;

    private String proName;

    private BigDecimal proPrice;

    private Integer proNum;

    private String proStatus;

    private Date createtime;

    private String proType;

    private String proDes;

    private String emp;

    private String proUnit;
}
