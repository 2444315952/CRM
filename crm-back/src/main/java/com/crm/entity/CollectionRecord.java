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
 * (CollectionRecord)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CollectionRecord implements Serializable {
    private static final long serialVersionUID = 715840366765813487L;

    private Integer collectionId;

    private Integer recordId;

    private Integer recordStaticId;

    private Integer empId;

    private BigDecimal paymentMoney;

    private Date paymentDate;

    private String paymentMode;

    private String remarks;
}
