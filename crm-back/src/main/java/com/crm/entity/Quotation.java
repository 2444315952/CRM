package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Quotation)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Quotation implements Serializable {
    private static final long serialVersionUID = -53926634101376922L;

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
