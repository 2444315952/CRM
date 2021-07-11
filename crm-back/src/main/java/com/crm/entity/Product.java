package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = -74460450556658894L;

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
