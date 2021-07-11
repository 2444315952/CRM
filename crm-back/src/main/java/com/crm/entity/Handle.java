package com.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Handle)实体类
 *
 * @author makejava
 * @since 2021-07-11 02:52:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Handle implements Serializable {
    private static final long serialVersionUID = 611918266677675736L;

    private Integer hid;

    private Integer proId;

    private String handId;

    private String handAction;

    private Integer handNum;

    private String handWay;

    private Integer billid;

    private Integer proid;

    private Date createtime;

    private String handStauts;

    private Date handTime;

    private String handEmp;

    private Object handDate;
}
