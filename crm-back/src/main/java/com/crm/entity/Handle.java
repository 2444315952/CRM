package com.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String handStauts;

    private Date handTime;

    private String handEmp;
    private Date handDate;

    private Integer sumNum;
}
