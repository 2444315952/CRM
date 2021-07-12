package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RecordStatic)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordStatic implements Serializable {
    private static final long serialVersionUID = 367481144862291339L;

    private Integer recordStaticId;

    private String recordStaticName;
}
