package com.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Follow)实体类
 *
 * @author makejava
 * @since 2021-07-11 14:45:28
 * @since 2021-07-11 17:51:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowPlanVo implements Serializable {
    private static final long serialVersionUID = -21799474009538548L;

    private Integer followId;

    private Integer empId;

    private String empName;

    private Integer clueId;

    private String clueName;

    private String followType;

    private String followContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date followTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date addtime;

    private int state;


}
