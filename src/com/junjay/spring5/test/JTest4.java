package com.junjay.spring5.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junjay.spring5.service.UserService;

/**
 * ����Junit4���Կ��
 *
 */
// @RunWith:������  SpringJUnit4ClassRunnerָ��JUnit4������
@RunWith(SpringJUnit4ClassRunner.class)
// ���������ļ�
@ContextConfiguration("classpath:bean1.xml")
public class JTest4 {

	@Autowired
	private UserService userService;

	@Test
	public void test1() {
		// ����1��ת���� ����2��ת�˽�� ����3������ת����
		userService.transfer("����", 100, "����");
	}

}
