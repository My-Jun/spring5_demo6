package com.junjay.spring5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

// @Configuration
// �������ɨ��
@ComponentScan(basePackages = "com.junjay.spring5")
//��������
@EnableTransactionManagement
public class TxConfig {

	// �������ݿ����ӳ�
	@Bean
	public DruidDataSource getDruidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	// ����JdbcTemplate����
	@Bean
	public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// ע��dataSource,��ioc�������ҵ�DruidDataSource�����ͽ���ע��
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}

	// ����DataSourceTransactionManager���������
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}

}
