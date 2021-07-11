package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (TaskEmp)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TaskEmp implements Serializable {
    private static final long serialVersionUID = 910268134475686023L;

    private Integer id;

    private Integer empId;

    private Integer taskId;
}
