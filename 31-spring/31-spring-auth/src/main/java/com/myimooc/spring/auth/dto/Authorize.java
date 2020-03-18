package com.myimooc.spring.auth.dto;

/**
 * Authorize
 *
 * @author zc 2017-08-19
 */
public class Authorize {

    private Long userRoleId;
    private Long userId;
    private String userName;
    private Long roleId;
    private String roleName;

    @Override
    public String toString() {
        return "Authorize [userRoleId=" + userRoleId + ", userId=" + userId + ", userName=" + userName + ", roleId="
                + roleId + ", roleName=" + roleName + "]";
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
