package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (Clue)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:23
 * @since 2021-07-11 17:51:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clue implements Serializable {
    private static final long serialVersionUID = -50495695225016762L;
    private static final long serialVersionUID = 500982595892292905L;

    private Integer activityId;

    private Integer clueId;

    private Integer publicpondId;

    private Integer empId;

    private String clueName;

    private String clueCompany;

    private String clueContacts;

    private String cluePhone;

    private Integer clueType;

    private Integer conversionType;
}
