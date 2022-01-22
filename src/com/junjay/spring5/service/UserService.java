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
	 * @param name        ת��������
	 * @param money       ת�˽��
	 * @param receiveName ����ת��������
	 */
	// @Transactional ���Լ���������Ҳ���Լ��ڷ�������
	public void transfer(String name, int money, String receiveName) {

		// �ڶ���������ҵ�����
		System.out.println("ת��ǰ--------------");
		userDao.reduceMoney(receiveName, money);

		System.out.println("ת����--------------");
		// ģ���쳣 ��ת����ͻȻͣ��
		// System.out.println(10 / 0);
		System.out.println("ת����ͻȻͣ��--------------");
		// ���ݻع���

		userDao.addMoney(name, money);
		System.out.println("ת�˳ɹ�--------------");

//		// ��һ���������������
//		try {
//			// �ڶ���������ҵ�����
//			System.err.println("ת��ǰ--------------");
//			userDao.reduceMoney(receiveName, money);
//
//			System.err.println("ת����--------------");
//			// ģ���쳣 ��ת����ͻȻͣ��
//			System.err.println("ת����ϵͳͣ��--------------");
//			int a = 10 / 0;
//
//			userDao.addMoney(name, money);
//			System.err.println("ת�˳ɹ�--------------");
//
//			// ��������û���쳣���ύ�������ݿ��޸ģ�
//		} catch (Exception e) {
//			// try{} ��Ϊ�����ҵ�������catch{} ��������ҵ�������������쳣�����ͻ����
//			// Exception e : Exception �쳣����
//			// ���Ĳ��������쳣��������ع����ظ�֮ǰ�����ݲ�����
//		}
	}

	public void queryUser(String name) {
		userDao.queryUser(name);
	}

}
