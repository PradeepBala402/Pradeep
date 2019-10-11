package com.spoors.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com.spoors.dao")
public class PersistenceConfig {
	@Bean
	public DataSource createDataSource() {
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/pradeep");
		bds.setUsername("root");
		bds.setPassword("password");
		return bds;
		
	}
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		return new JdbcTemplate(createDataSource());
	}

}
