package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:27
 * @since 2021-07-11 17:51:27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = -81257947186624513L;

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
