package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.junjay.spring5.service.UserService;

/**
 * ����Junit5���Կ��
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean1.xml")
public class JTest5 {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		userService.transfer("����", 100, "����");
	}

}
