package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Contacts)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Contacts implements Serializable {
    private static final long serialVersionUID = 131209026387130883L;

    private Integer contactsId;

    private String contactsName;

    private String contactsPhone;

    private Integer contactsType;
}
