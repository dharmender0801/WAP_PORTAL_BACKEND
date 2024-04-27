package com.wap.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.wap.model.ConnectionCrendential;
import com.wap.respos.ConnectionCrendentialRepo;

@Component
public class DatabaseConnectionInitializer implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private DbConnectionManager dbConnectionManager;

	@Autowired
	private ConnectionCrendentialRepo connectionCrendentialRepo;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		List<ConnectionCrendential> connectionCrendentials = connectionCrendentialRepo.findAll();
		connectionCrendentials.forEach(n -> {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(n.getUrl(), n.getUsername(), n.getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbConnectionManager.addConnection(n.getServerKey(), connection);
		});
	}
}