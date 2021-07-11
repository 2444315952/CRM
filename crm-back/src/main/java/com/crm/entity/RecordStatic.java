package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (RecordStatic)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class RecordStatic implements Serializable {
    private static final long serialVersionUID = 250357776797179975L;

    private Integer recordStaticId;

    private String recordStaticName;


    public Integer getRecordStaticId() {
        return recordStaticId;
    }

    public void setRecordStaticId(Integer recordStaticId) {
        this.recordStaticId = recordStaticId;
    }

    public String getRecordStaticName() {
        return recordStaticName;
    }

    public void setRecordStaticName(String recordStaticName) {
        this.recordStaticName = recordStaticName;
    }

}
