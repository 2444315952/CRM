package com.crm.vo;

import lombok.Data;

@Data
public class OutInStoreBillReq {
    private int hId;//出入库表主键id
    private String handId;//出入库单编号
    private String storeAction;
    private String mode;
    private String handDate;
    private Integer outInStoreNum;
    private String handStauts;
    private int proId;//产品编号
}
