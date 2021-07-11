package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (SaleReturn)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleReturn implements Serializable {
    private static final long serialVersionUID = -41795661627925744L;

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
