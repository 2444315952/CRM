package com.crm.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (SaleOrder)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:33
 * @since 2021-07-11 17:51:33
 * @since 2021-07-13 09:39:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleOrder {

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private Integer activityId;

    private String saleOrderName;

    private BigDecimal saleOrderAmount;

    private Date createDate;

    private Date transactionDate;

    private Date startDate;

    private Date endDate;

    private String paymentMothod;

    private String saleOrderState;

    private String saleOrderRemark;

    private Integer saleContractId;


    private BigDecimal collectionAmount;

    private BigDecimal receiptAmount;

    private String customerName;

    private String empName;

    private List<SaleProduct> saleProductList;

    public BigDecimal getCollectionAmount() {
        if(collectionAmount==null)
            return new BigDecimal(0);
        return collectionAmount;
    }

    public BigDecimal getReceiptAmount() {
        if(receiptAmount==null)
            return new BigDecimal(0);
        return receiptAmount;
    }
}
