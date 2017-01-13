package com.lxg.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName;
	private String password;
	private String proFile;
	private String nickName;
	private String sign;
	private String imageName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public User() {
		super();
	}
	public User(Integer id, String userName, String password, String proFile, String nickName, String sign,
			String imageName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.proFile = proFile;
		this.nickName = nickName;
		this.sign = sign;
		this.imageName = imageName;
	}

	
}
