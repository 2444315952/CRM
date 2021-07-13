package com.crm.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * clue
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clue implements Serializable {
    private Integer clueId;

    private String clueName;

    private String clueCompany;

    private String clueContacts;

    private String cluePhone;

    private Integer conversionType;

    private Integer timeliness;

    private Integer activityId;
    private Activity activity;

    private Integer publicpondId;
    private Publicpond publicpond;

    private Integer empId;
    private Employee employee;

    private static final long serialVersionUID = 1L;
}