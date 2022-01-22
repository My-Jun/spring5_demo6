package com.junjay.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junjay.spring5.dao.UserDao;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * @param name        转账人名称
	 * @param money       转账金额
	 * @param receiveName 接收转账人名称
	 */
	// @Transactional 可以加在类上面也可以加在方法上面
	public void transfer(String name, int money, String receiveName) {

		// 第二步：进行业务操作
		System.out.println("转账前--------------");
		userDao.reduceMoney(receiveName, money);

		System.out.println("转账中--------------");
		// 模拟异常 在转账中突然停电
		// System.out.println(10 / 0);
		System.out.println("转账中突然停电--------------");
		// 数据回滚后

		userDao.addMoney(name, money);
		System.out.println("转账成功--------------");

//		// 第一步：开启事务操作
//		try {
//			// 第二步：进行业务操作
//			System.err.println("转账前--------------");
//			userDao.reduceMoney(receiveName, money);
//
//			System.err.println("转账中--------------");
//			// 模拟异常 在转账中突然停电
//			System.err.println("转账中系统停电--------------");
//			int a = 10 / 0;
//
//			userDao.addMoney(name, money);
//			System.err.println("转账成功--------------");
//
//			// 第三步：没有异常则提交事务（数据库修改）
//		} catch (Exception e) {
//			// try{} 内为具体的业务操作，catch{} 内则是在业务操作中如果有异常或错误就会进入
//			// Exception e : Exception 异常类型
//			// 第四步：出现异常，则事务回滚（回复之前的数据操作）
//		}
	}

	public void queryUser(String name) {
		userDao.queryUser(name);
	}

}
