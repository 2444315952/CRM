package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (SaleContract)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleContract implements Serializable {
    private static final long serialVersionUID = -25905836751928758L;

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
