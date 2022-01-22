package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.junjay.spring5.service.UserService;

/**
 * ����Junit5��Junit4 ���Կ��
 *
 */
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class JTest {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		userService.transfer("����", 100, "����");
	}

}
