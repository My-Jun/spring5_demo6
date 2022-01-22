package com.junjay.spring5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

// @Configuration
// 开启组件扫描
@ComponentScan(basePackages = "com.junjay.spring5")
//开启事务
@EnableTransactionManagement
public class TxConfig {

	// 创建数据库连接池
	@Bean
	public DruidDataSource getDruidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	// 创建JdbcTemplate对象
	@Bean
	public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// 注入dataSource,到ioc容器中找到DruidDataSource该类型进行注入
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}

	// 创建DataSourceTransactionManager事务管理器
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}

}
