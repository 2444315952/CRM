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
 * @since 2021-07-11 11:28:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Activity implements Serializable {
    private static final long serialVersionUID = -28731547927454180L;

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
