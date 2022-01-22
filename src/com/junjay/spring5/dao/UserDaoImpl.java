package com.junjay.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.junjay.spring5.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// ע��jdbctemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addMoney(String name, int money) {
		// ��Ǯ����
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("ת��ǰ��"+name+"�˻����У�"+user.getMoney());
		String sql=" UPDATE test.T_ACCOUNT SET  MONEY=MONEY+?  WHERE (USERNAME=?) ";
		int i = jdbcTemplate.update(sql, money,name);
		System.out.println("Ӱ��������"+i);
		User user1 = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("ת�˺�"+name+"�˻����У�"+user1.getMoney()+",����ת�˽�"+money);
	}

	@Override
	public void reduceMoney(String name, int money) {
		// ��Ǯ����
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("ת��ǰ��"+name+"�˻����У�"+user.getMoney());
		String sql=" UPDATE test.T_ACCOUNT SET  MONEY=MONEY-?  WHERE (USERNAME=?) ";
		int i = jdbcTemplate.update(sql, money,name);
		System.out.println("Ӱ��������"+i);
		User user1 = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("ת�˺�"+name+"�˻����У�"+user1.getMoney()+",����ת�˽�"+money);
	}

	@Override
	public void queryUser(String name) {
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("ת�˻ع���"+name+"�˻����У�"+user.getMoney());
	}


}
