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
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Publicpond implements Serializable {
    private static final long serialVersionUID = 877850296063600695L;

    private Integer publicpondId;

    private Integer empId;

    private String publicpondName;
}
