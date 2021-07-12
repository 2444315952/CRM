package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (SaleReturn)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:34
 * @since 2021-07-11 17:51:34
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleReturn implements Serializable {
    private static final long serialVersionUID = 969176808502558418L;

    private Integer saleReturnId;

    private Integer saleOrderId;

    private Integer empId;

    private Integer customerId;

    private String saleReturnName;

    private Date returnDate;

    private BigDecimal returnAmount;

    private String returnMethod;

    private String returnCause;

    private String returnRemark;
}
