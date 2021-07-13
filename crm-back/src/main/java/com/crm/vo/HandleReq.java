package com.crm.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HandleReq {
    private Integer hid;//出入库单的id值
    private Integer sumNum;
    private Integer proId;//产品id
    private Integer handProId;//出入库单明细表的id
    private Date handDate;//出库日期
}
