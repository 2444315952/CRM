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
 * @since 2021-07-11 11:28:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CollectionPeriod implements Serializable {
    private static final long serialVersionUID = -88467871058220924L;

    private Integer collectionId;

    private Integer empId;

    private String beriodName;

    private BigDecimal blannedMoeny;

    private Date blannedDate;

    private String remarks;

    private BigDecimal bmountMoeny;

    private BigDecimal billing;
}
