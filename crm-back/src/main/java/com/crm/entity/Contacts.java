package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Contacts)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contacts implements Serializable {
    private static final long serialVersionUID = -64762813450268090L;

    private Integer contactsId;

    private String contactsName;

    private String contactsPhone;

    private Integer contactsType;
}
