package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (TaskEmp)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:18
 */
public class TaskEmp implements Serializable {
    private static final long serialVersionUID = -59631348652048805L;

    private Integer id;

    private Integer empId;

    private Integer taskId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

}
