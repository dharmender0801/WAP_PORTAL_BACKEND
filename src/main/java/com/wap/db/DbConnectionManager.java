package com.wap.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DbConnectionManager {
	private final Map<String, Connection> connections = new HashMap<>();

	public void addConnection(String key, Connection connection) {
		connections.put(key, connection);
	}

	public Connection getConnection(String key) {
		return connections.get(key);
	}

	public void closeConnections() throws SQLException {
		for (Connection connection : connections.values()) {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		connections.clear();
	}
}
