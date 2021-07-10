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
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaleContract implements Serializable {
    private static final long serialVersionUID = 666438837009980198L;

    private Integer saleContractId;

    private Integer saleOrderId;

    private Integer leadId;

    private Integer empId;

    private String contractName;

    private Date contractDate;

    private String contractSate;

    private Date startDate;

    private Date endDate;
}
