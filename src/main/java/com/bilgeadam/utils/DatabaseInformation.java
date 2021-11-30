package com.bilgeadam.utils;

public class DatabaseInformation {
	private String url;
	private String userName;
	private String password;
	private String forNameData;

	public DatabaseInformation() {
		this.url = "jdbc:postgresql://localhost:5432/blogproject";
		this.userName = "boost";
		this.password = "boost";
		this.forNameData = "org.postgresql.Driver";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getForNameData() {
		return forNameData;
	}

	public void setForNameData(String forNameData) {
		this.forNameData = forNameData;
	}
}
