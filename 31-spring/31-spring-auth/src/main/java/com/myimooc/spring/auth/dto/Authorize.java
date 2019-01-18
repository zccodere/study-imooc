package com.myimooc.spring.auth.dto;

/**
 * Authorize
 * @author zc on 2017-08-19
 */
public class Authorize {
	
	private Long userRoleId;
	private Long userId;
	private String userName;
	private Long roleId;
	private String roleNmae;
	@Override
	public String toString() {
		return "Authorize [userRoleId=" + userRoleId + ", userId=" + userId + ", userName=" + userName + ", roleId="
				+ roleId + ", roleNmae=" + roleNmae + "]";
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
	public String getRoleNmae() {
		return roleNmae;
	}
	public void setRoleNmae(String roleNmae) {
		this.roleNmae = roleNmae;
	}
	
	
	
}
