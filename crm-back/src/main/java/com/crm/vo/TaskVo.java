package com.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2021-07-13 22:10:38
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskVo implements Serializable {
    private static final long serialVersionUID = 907101540356620712L;
    
    private Integer taskId;
    
    private Integer empId;

    private String empName;

    private Integer clueId;

    private String clueName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date closingtime;
    private String taskPerson;
    private String taskName;
    private String task;
    
    private Integer taskState;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endtime;


}