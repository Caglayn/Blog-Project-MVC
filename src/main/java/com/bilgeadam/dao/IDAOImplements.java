package com.bilgeadam.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.bilgeadam.utils.DatabaseConnection;

public interface IDAOImplements<T> {
	public void create(T dto);

	public void update(T dto);

	public void delete(T dto);

	public ArrayList<T> list();

	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
	}
}
