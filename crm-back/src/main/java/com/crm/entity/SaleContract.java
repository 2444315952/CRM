package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (SaleContract)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleContract implements Serializable {
    private static final long serialVersionUID = 704628740964775904L;

    private Integer saleContractId;

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private Integer customerId;

    private String contractName;

    private Date contractDate;

    private String contractSate;

    private Date startDate;

    private Date endDate;
}
