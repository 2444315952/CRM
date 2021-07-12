package com.crm.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (Follow)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:28
 * @since 2021-07-11 17:51:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow implements Serializable {
    private static final long serialVersionUID = -21799474009538548L;
    private static final long serialVersionUID = 729109743495919106L;

    private Integer followId;

    private Integer empId;

    private String followType;

    private String followContent;

    private Date followTime;

    private Date addtime;
}
