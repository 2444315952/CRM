package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Handle)实体类
 *
 * @author makejava
 * @since 2021-07-11 17:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Handle implements Serializable {
    private static final long serialVersionUID = 647865356585165357L;

    private Integer hid;

    private String handId;

    private String handAction;

    private String handWay;

    private Integer billid;

    private Date createtime;

    private String handStauts;

    private Date handTime;

    private String handEmp;

    private Date handDate;

    private Integer sumNum;
}
