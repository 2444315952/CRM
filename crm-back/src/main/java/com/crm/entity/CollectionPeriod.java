package com.crm.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (CollectionPeriod)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CollectionPeriod implements Serializable {
    private static final long serialVersionUID = -69226594092377851L;
    private Integer saleorderIid;

    private Integer collectionId;

    private Integer empId;

    private String beriodName;

    private BigDecimal blannedMoeny;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date blannedDate;

    private String remarks;

    private BigDecimal bmountMoeny;

    private BigDecimal billing;
}
