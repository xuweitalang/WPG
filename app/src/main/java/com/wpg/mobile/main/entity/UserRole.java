package com.wpg.mobile.main.entity;

/**
 * package: com.wpg.mobile.mobilemr.mvp.user.model.entity
 * author: Taozebi
 * datetime: 2020/9/21 17:00
 * describe: describe of this class
 */
public class UserRole {


    /**
     * roleId : 07eee0e434d440df990619e6bd9f98bf
     * roleName : 和静营收收费员角色
     */

    private String roleId;
    private String roleName;

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

    @Override
    public String toString() {
        return "RoleBean{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
