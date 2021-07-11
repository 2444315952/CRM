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
 * (SaleOrder)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleOrder implements Serializable {
    private static final long serialVersionUID = -40931795027851171L;

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private Integer activityId;

    private String saleOrderName;

    private BigDecimal saleOrderAmount;

    private Date transactionDate;

    private Date startDate;

    private Date endDate;

    private String paymentMothod;

    private String saleOrderState;

    private String saleOrderRemark;
}
