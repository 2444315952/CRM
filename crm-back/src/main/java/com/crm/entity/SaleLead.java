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
 * (SaleLead)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleLead implements Serializable {
    private static final long serialVersionUID = 805032969642514393L;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private Integer activityId;

    private String leadName;

    private BigDecimal leadAmount;

    private Date transactionDate;

    private String leadStage;

    private String leadType;

    private String leadSource;

    private String leadRemark;
}
