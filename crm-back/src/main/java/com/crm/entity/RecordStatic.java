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
 * @since 2021-07-11 11:28:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RecordStatic implements Serializable {
    private static final long serialVersionUID = 719264206991310829L;

    private Integer recordStaticId;

    private String recordStaticName;
}
