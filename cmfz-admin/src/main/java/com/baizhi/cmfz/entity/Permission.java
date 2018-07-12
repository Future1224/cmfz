package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-12 19:38
 */
public class Permission implements Serializable {

    private String permissionId;
    private String permissionName;
    private String permissionTag;


    public Permission() {
        super();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }
}
