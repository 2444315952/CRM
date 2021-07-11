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
 * @since 2021-07-11 11:28:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Record implements Serializable {
    private static final long serialVersionUID = 613220718575991968L;

    private Integer recordId;

    private Integer followId;

    private String recordType;

    private String recordContent;

    private String recordName;

    private Date recordTime;
}
