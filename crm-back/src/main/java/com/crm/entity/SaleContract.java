package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SaleContract)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:32
 */
@AllArgsConstructor
@Data
public class SaleContract implements Serializable {
    private static final long serialVersionUID = 878360724937631178L;

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
