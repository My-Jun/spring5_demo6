package com.junjay.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.junjay.spring5.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// 注入jdbctemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addMoney(String name, int money) {
		// 多钱方法
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("转账前，"+name+"账户中有："+user.getMoney());
		String sql=" UPDATE test.T_ACCOUNT SET  MONEY=MONEY+?  WHERE (USERNAME=?) ";
		int i = jdbcTemplate.update(sql, money,name);
		System.out.println("影响条数："+i);
		User user1 = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("转账后，"+name+"账户中有："+user1.getMoney()+",本次转账金额："+money);
	}

	@Override
	public void reduceMoney(String name, int money) {
		// 少钱方法
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("转账前，"+name+"账户中有："+user.getMoney());
		String sql=" UPDATE test.T_ACCOUNT SET  MONEY=MONEY-?  WHERE (USERNAME=?) ";
		int i = jdbcTemplate.update(sql, money,name);
		System.out.println("影响条数："+i);
		User user1 = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("转账后，"+name+"账户中有："+user1.getMoney()+",本次转账金额："+money);
	}

	@Override
	public void queryUser(String name) {
		String querySql=" SELECT * FROM t_account where USERNAME =? ";
		User user = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<User>(User.class), name);
		System.out.println("转账回滚，"+name+"账户中有："+user.getMoney());
	}


}
