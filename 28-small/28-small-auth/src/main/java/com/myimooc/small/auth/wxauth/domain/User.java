package com.myimooc.small.auth.wxauth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 自有用户账号体系
 * @author ZhangCheng on 2017-08-12
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String account;
	private String password;
	private String nickname;
	private String openid;
	private String unionid;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", nickname=" + nickname
				+ ", openid=" + openid + "]";
	}
	
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
	
}
