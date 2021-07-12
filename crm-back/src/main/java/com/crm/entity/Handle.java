package com.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 出入库办理实体类
 * (Handle)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:29
 * @since 2021-07-11 17:51:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@NoArgsConstructor
public class Handle implements Serializable {
    private Integer hid;//出入库id
    private String handId;//出入库单编号【CKD201912180001，】
    private String handAction;//库存动作【出/入库】
    private String handWay;//发起方式【销售订单、退货单、其他】
    private Integer billid;//绑定的单据表的id
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    private String handStauts;//办理状态【未办理、已办理】
    private Date handTime;//办理时间
    private String handEmp;//办理人员
    private Date handDate;//出入库日期
    private Integer sumNum;//出入库单的数量合计
}
