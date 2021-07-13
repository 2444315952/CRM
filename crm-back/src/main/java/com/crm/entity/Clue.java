package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 单位表(Clue)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:23
 * @since 2021-07-11 17:51:24
 * @since 2021-07-13 15:08:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clue {
    /**
     * 线索及客户编号
     */
    private Integer clueId;
    /**
     * 线索及客户名称
     */
    private String clueName;
    /**
     * 线索及客户所属公司
     */
    private String clueCompany;
    /**
     * 线索及客户联系人
     */
    private String clueContacts;
    /**
     * 线索及客户联系人电话
     */
    private String cluePhone;
    /**
     * 线索转化状态
     */
    private Integer conversionType;
    /**
     * 时效性
     */
    private Integer timeliness;
    /**
     * 市场活动编号
     */
    private Integer activityId;
    /**
     * 公海编号
     */
    private Integer publicpondId;
    /**
     * 职员编号
     */
    private Integer empId;
}
