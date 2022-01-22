package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junjay.spring5.service.UserService;

/**
 * 整合Junit4测试框架
 *
 */
// @RunWith:运行器  SpringJUnit4ClassRunner指用JUnit4来运行
@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件
@ContextConfiguration("classpath:bean1.xml")
public class JTest4 {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		userService.transfer("张三", 100, "李四");
	}

}
