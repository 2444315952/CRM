package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (Publicpond)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:17
 */
public class Publicpond implements Serializable {
    private static final long serialVersionUID = 484963459796783337L;

    private Integer publicpondId;

    private Integer empId;

    private String publicpondName;


    public Integer getPublicpondId() {
        return publicpondId;
    }

    public void setPublicpondId(Integer publicpondId) {
        this.publicpondId = publicpondId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getPublicpondName() {
        return publicpondName;
    }

    public void setPublicpondName(String publicpondName) {
        this.publicpondName = publicpondName;
    }

}
