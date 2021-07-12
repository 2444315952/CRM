package com.crm.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Record implements Serializable {
    private static final long serialVersionUID = 958605497634352859L;

    private Integer recordId;

    private Integer followId;

    private String recordType;

    private String recordContent;

    private String recordName;

    private Date recordTime;
}
