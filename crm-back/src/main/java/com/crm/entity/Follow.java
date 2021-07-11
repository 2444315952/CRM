package com.crm.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (Follow)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Follow implements Serializable {
    private static final long serialVersionUID = 559139256058134847L;

    private Integer followId;

    private Integer empId;

    private String followType;

    private String followContent;

    private Date followTime;

    private Date addtime;
}
