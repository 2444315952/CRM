package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (Contacts)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:25
 */
@AllArgsConstructor
@Data
public class Contacts implements Serializable {
    private static final long serialVersionUID = 700514545094853962L;

    private Integer contactsId;

    private String contactsName;

    private String contactsPhone;

    private Integer contactsType;
}
