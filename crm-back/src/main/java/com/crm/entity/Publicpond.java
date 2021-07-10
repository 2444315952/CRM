package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Publicpond)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Publicpond implements Serializable {
    private static final long serialVersionUID = 285507745730253927L;

    private Integer publicpondId;

    private Integer empId;

    private String publicpondName;
}
