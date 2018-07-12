package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-12 19:35
 */
public class Role implements Serializable {

    private String roleId;
    private String roleName;
    private String roleTag;


    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public Role() {
        super();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
