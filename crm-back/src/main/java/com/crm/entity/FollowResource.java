package com.crm.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/**
 * (FollowResource)实体类
 *
 * @author makejava
 * @since 2021-07-11 11:35:19
 */
public class FollowResource implements Serializable {
    private static final long serialVersionUID = 930115888604535914L;

    private Integer followResourceId;

    private Integer followId;

    private String resourceType;

    private Integer resourceId;


    public Integer getFollowResourceId() {
        return followResourceId;
    }

    public void setFollowResourceId(Integer followResourceId) {
        this.followResourceId = followResourceId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

}
