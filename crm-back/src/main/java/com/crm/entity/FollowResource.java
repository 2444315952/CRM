package com.crm.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * (FollowResource)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:28:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FollowResource implements Serializable {
    private static final long serialVersionUID = 436630660385982735L;

    private Integer followResourceId;

    private Integer followId;

    private String resourceType;

    private Integer resourceId;
}
