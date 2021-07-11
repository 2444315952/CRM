package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (RecordStatic)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:32
 */
@AllArgsConstructor
@Data
public class RecordStatic implements Serializable {
    private static final long serialVersionUID = -11185542756503528L;

    private Integer recordStaticId;

    private String recordStaticName;
}
