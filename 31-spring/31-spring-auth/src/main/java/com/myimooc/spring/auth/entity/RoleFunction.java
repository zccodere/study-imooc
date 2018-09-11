package com.myimooc.spring.auth.entity;

import com.myimooc.spring.auth.common.BaseEntity;

/**
 * 角色菜单功能实体类
 * @author zc on 2017-08-19
 */
public class RoleFunction extends BaseEntity{
	
	private Long roleId;
	private Long functionId;
	private Integer status;
	
	@Override
	public String toString() {
		return "RoleFunction [roleId=" + roleId + ", functionId=" + functionId + ", status=" + status + "]";
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
