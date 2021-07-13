package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Quotation)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quotation implements Serializable {
    private static final long serialVersionUID = -21218268285413882L;

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


    private String customerName;

    private String empName;
}
