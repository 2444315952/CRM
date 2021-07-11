package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = -45802613789779943L;

    private Integer proId;

    private Integer empId;

    private String proName;

    private Integer proPrice;

    private Integer proNum;

    private String proStatus;

    private Date createtime;

    private String proType;

    private String proDes;

    private String emp;

    private String proUnit;
}
