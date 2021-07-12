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
 * @since 2021-07-11 14:45:34
 * @since 2021-07-11 17:51:34
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskEmp implements Serializable {
    private static final long serialVersionUID = -58912315732539138L;

    private Integer id;

    private Integer empId;

    private Integer taskId;
}
