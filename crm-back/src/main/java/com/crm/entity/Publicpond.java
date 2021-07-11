package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (Publicpond)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:30
 */
@AllArgsConstructor
@Data
public class Publicpond implements Serializable {
    private static final long serialVersionUID = -61468589232030265L;

    private Integer publicpondId;

    private Integer empId;

    private String publicpondName;
}
