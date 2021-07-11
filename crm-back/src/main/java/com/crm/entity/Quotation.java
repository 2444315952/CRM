package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Quotation)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:30
 */
@AllArgsConstructor
@Data
public class Quotation implements Serializable {
    private static final long serialVersionUID = -25139786626055737L;

    private Integer quotationId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private String quotationName;

    private String quotationStage;

    private BigDecimal quotationAmount;

    private Date effectiveDate;

    private Date quotationDate;

    private String quotationRemark;
}
