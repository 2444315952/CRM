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
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Quotation implements Serializable {
    private static final long serialVersionUID = -10703638838527251L;

    private Integer quotationId;

    private Integer leadId;

    private Integer empId;

    private String quotationName;

    private String quotationStage;

    private BigDecimal quotationAmount;

    private Date effectiveDate;

    private Date quotationDate;

    private String quotationRemark;
}
