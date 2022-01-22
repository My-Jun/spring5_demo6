package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.junjay.spring5.service.UserService;

/**
 * 整合Junit5测试框架
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean1.xml")
public class JTest5 {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		userService.transfer("张三", 100, "李四");
	}

}
