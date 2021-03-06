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
 * @since 2021-07-11 14:45:25
 * @since 2021-07-11 17:51:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollectionRecord implements Serializable {
    private static final long serialVersionUID = 998671494441812382L;

    private Integer collectionId;
    private Integer state;
    private Integer recordId;

    private Integer recordStaticId;

    private Integer empId;

    private BigDecimal paymentMoney;

    private Date paymentDate;

    private String paymentMode;
    private Integer saleorderId;
    private String remarks;
}
