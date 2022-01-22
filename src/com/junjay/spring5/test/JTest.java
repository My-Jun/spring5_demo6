package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.junjay.spring5.service.UserService;

/**
 * 复合Junit5和Junit4 测试框架
 *
 */
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class JTest {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		userService.transfer("张三", 100, "李四");
	}

}
