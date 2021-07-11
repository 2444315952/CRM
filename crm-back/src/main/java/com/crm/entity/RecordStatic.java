package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (RecordStatic)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RecordStatic implements Serializable {
    private static final long serialVersionUID = -27535015551554019L;

    private Integer recordStaticId;

    private String recordStaticName;
}
