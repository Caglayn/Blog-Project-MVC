package com.bilgeadam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection connection;

	private static DatabaseInformation databaseInformation;

	private String url = databaseInformation.getUrl();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();

	private static DatabaseConnection instance;

	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("Driver yüklendi.");

			this.connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Bağlantı başarılı.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static {
		databaseInformation = new DatabaseInformation();
	}

	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		try {
			if (this.connection.isClosed())
				this.connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}
