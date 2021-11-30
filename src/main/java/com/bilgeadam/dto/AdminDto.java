package com.bilgeadam.dto;

public class AdminDto extends CommonProperty {
	private static final long serialVersionUID = -6214174547778684454L;

	private int registerNumberOfRecords;

	public AdminDto() {
	}

	public AdminDto(String name, String surName, String telNumber, String emailAddress, String password,
			int registerNumberOfRecords) {
		super(name, surName, telNumber, emailAddress, password);
		this.registerNumberOfRecords = registerNumberOfRecords;
	}

	public int getRegisterNumberOfRecords() {
		return registerNumberOfRecords;
	}

	public void setRegisterNumberOfRecords(int registerNumberOfRecords) {
		this.registerNumberOfRecords = registerNumberOfRecords;
	}

}
