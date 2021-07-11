package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Publicpond)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publicpond implements Serializable {
    private static final long serialVersionUID = -19108213484347077L;

    private Integer publicpondId;

    private Integer empId;

    private String publicpondName;
}
