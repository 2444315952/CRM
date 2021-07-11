package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (SaleLead)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:32
 */
@AllArgsConstructor
@Data
public class SaleLead implements Serializable {
    private static final long serialVersionUID = -68652117473794176L;

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
