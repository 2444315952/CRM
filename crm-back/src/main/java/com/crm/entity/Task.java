package com.crm.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class Task implements Serializable {
    private static final long serialVersionUID = -20960674942015798L;

    private Integer taskId;

    private Integer empId;

    private Date closingtime;

    private String task;

    private Integer taskState;

    private Date endtime;


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getClosingtime() {
        return closingtime;
    }

    public void setClosingtime(Date closingtime) {
        this.closingtime = closingtime;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

}
