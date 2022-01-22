package com.junjay.spring5.dao;

public interface UserDao {

	void addMoney(String name, int money);

	void reduceMoney(String name, int money);

	void queryUser(String name);


}
