package com.crm.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (CollectionPeriod)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:24
 */
@AllArgsConstructor
@Data
public class CollectionPeriod implements Serializable {
    private static final long serialVersionUID = -69226594092377851L;
    private Integer saleorderIid;

    private Integer collectionId;

    private Integer empId;

    private String beriodName;

    private BigDecimal blannedMoeny;

    private Date blannedDate;

    private String remarks;

    private BigDecimal bmountMoeny;

    private BigDecimal billing;
}
