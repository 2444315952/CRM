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
 * (Activity)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:21
 * @since 2021-07-11 17:51:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity implements Serializable {
    private static final long serialVersionUID = -26085757277589739L;

    private Integer activityId;

    private Integer empId;

    private String activityName;

    private Date addTime;

    private Date endTime;

    private String address;

    private Integer activityType;

    private Integer activityState;

    private BigDecimal planincome;

    private BigDecimal actualincome;

    private BigDecimal profitloss;

    private String activityPlan;
}
