package com.junjay.spring5.entity;

public class User {

	private String id;
	private String userName;
	private String money;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", money=" + money + "]";
	}

	public User(String id, String userName, String money) {
		super();
		this.id = id;
		this.userName = userName;
		this.money = money;
	}

	public User() {
		super();
	}

}
