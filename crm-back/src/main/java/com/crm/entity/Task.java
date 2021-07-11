package com.crm.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Task implements Serializable {
    private static final long serialVersionUID = 346782242812992319L;

    private Integer taskId;

    private Integer empId;

    private Date closingtime;

    private String task;

    private Integer taskState;

    private Date endtime;
}
