package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Contacts)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class Contacts implements Serializable {
    private static final long serialVersionUID = -78433300770158662L;

    private Integer contactsId;

    private String contactsName;

    private String contactsPhone;

    private Integer contactsType;


    public Integer getContactsId() {
        return contactsId;
    }

    public void setContactsId(Integer contactsId) {
        this.contactsId = contactsId;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public Integer getContactsType() {
        return contactsType;
    }

    public void setContactsType(Integer contactsType) {
        this.contactsType = contactsType;
    }

}
