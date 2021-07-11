package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer implements Serializable {
    private static final long serialVersionUID = -86569268016466886L;

    private Integer activityId;

    private Integer customerId;

    private Integer publicpondId;

    private Integer empId;

    private String customerName;

    private String customerCompany;

    private String customerContacts;

    private String customerPhone;

    private Integer customerType;
}
