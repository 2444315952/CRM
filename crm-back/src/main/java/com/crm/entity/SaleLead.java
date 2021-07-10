package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (SaleLead)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleLead implements Serializable {
    private static final long serialVersionUID = -13745787027566223L;

    private Integer leadId;

    private Integer empId;

    private String leadName;

    private String leadAmount;

    private Date transactionDate;

    private String leadStage;

    private String leadType;

    private String leadSource;

    private String leadRemark;
}
