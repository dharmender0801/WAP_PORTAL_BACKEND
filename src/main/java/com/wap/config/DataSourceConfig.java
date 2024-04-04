package com.wap.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.wap.model.ServiceContent;
import com.wap.respos.ServiceRepository;

@Configuration
public class DataSourceConfig {

	@Autowired
	private ServiceRepository repository;

	public List<DataSource> getDataSource() {
		List<DataSource> dataSources = new ArrayList<>();
		List<ServiceContent> config = repository.findAll();
		config.forEach(n -> {
//			dataSources.add(creatDataSource(n));
		});
		return dataSources;
	}

//	private DataSource creatDataSource(ServiceContent n) {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // Change the driver class if needed
//		dataSource.setUrl(n.getServiceData().g));
//		dataSource.setUsername(config.getUsername());
//		dataSource.setPassword(config.getPassword());
//		return dataSource;
//	}
}
