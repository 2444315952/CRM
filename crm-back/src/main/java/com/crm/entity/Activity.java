package com.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

/**
 * activity
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Activity implements Serializable {
    private Integer activityId;

    private Integer empId;
    private Employee employee;

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

    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}