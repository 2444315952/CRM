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
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleReturn implements Serializable {
    private static final long serialVersionUID = -15744689802812507L;

    private Integer saleReturnId;

    private Integer saleOrderId;

    private Integer empId;

    private String saleReturnName;

    private Date returnDate;

    private BigDecimal returnAmount;

    private String returnMethod;

    private String returnCause;

    private String returnRemark;
}
