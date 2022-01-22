package com.junjay.spring5.test;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.junjay.spring5.config.TxConfig;
import com.junjay.spring5.entity.Book;
import com.junjay.spring5.service.UserService;

public class TextBean {

	@Test
	public void testJdabTransfer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		userService.transfer("张三", 100, "李四");
//			userService.queryUser("张三");
	}

	@Test
	public void testJdabTransferXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		try {
			userService.transfer("张三", 100, "李四");
		} catch (Exception e) {
			System.err.println("转账中出现异常！！！");
			userService.queryUser("张三");
		}
	}

	@Test
	public void testJdabTransferConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		// 参数1：转账人 参数2：转账金额 参数3：接收转账人
		try {
			userService.transfer("张三", 100, "李四");
		} catch (Exception e) {
			System.err.println("转账中出现异常！！！");
			userService.queryUser("张三");
		}
	}

	
	/**
	 * 函数式创建对象，交给spring管理
	 */
	@Test
	public void testGenericApplicationContext() {
		// 1:创建GenericApplicationContext对象
		GenericApplicationContext context = new GenericApplicationContext();
		// 2：调用context的方法进行对象注册
		// 利用lambda表达式进行创建对象，注册对象
		context.registerBean("textBook",Book.class,()->new Book());
		// 3：context刷新容器
		context.refresh();
		// 4：再获取spring注册对象
		Book book = (Book) context.getBean("textBook");
		System.err.println(book);
		
	}

}
