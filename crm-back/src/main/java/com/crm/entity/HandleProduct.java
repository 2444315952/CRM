package com.crm.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 出入库办理明细实体类
 */
@Data
public class HandleProduct implements Serializable {
    private Integer handleProductId;//出入库明细id
    private Integer proId;//绑定的产品表的id
    private Integer hid;//绑定的出入库办理表的id
    private Integer handNum;//单件产品的出入库数量
}