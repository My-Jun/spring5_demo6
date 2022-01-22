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
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		userService.transfer("����", 100, "����");
//			userService.queryUser("����");
	}

	@Test
	public void testJdabTransferXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService userService = context.getBean("userService", UserService.class);
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		try {
			userService.transfer("����", 100, "����");
		} catch (Exception e) {
			System.err.println("ת���г����쳣������");
			userService.queryUser("����");
		}
	}

	@Test
	public void testJdabTransferConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		try {
			userService.transfer("����", 100, "����");
		} catch (Exception e) {
			System.err.println("ת���г����쳣������");
			userService.queryUser("����");
		}
	}

	
	/**
	 * ����ʽ�������󣬽���spring����
	 */
	@Test
	public void testGenericApplicationContext() {
		// 1:����GenericApplicationContext����
		GenericApplicationContext context = new GenericApplicationContext();
		// 2������context�ķ������ж���ע��
		// ����lambda���ʽ���д�������ע�����
		context.registerBean("textBook",Book.class,()->new Book());
		// 3��contextˢ������
		context.refresh();
		// 4���ٻ�ȡspringע�����
		Book book = (Book) context.getBean("textBook");
		System.err.println(book);
		
	}

}
