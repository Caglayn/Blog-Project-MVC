package com.bilgeadam.dto;

// Model ==> DTO : data transfer object
public class UserDto extends CommonProperty {
	private static final long serialVersionUID = -6909316477482845301L;

	private boolean isActive;
	private String HesCode;
	private int adminId;

	public UserDto() {
		super();
		this.isActive = false;
	}

	public UserDto(String name, String surName, String telNumber, String emailAddress, String password,
			boolean isActive, String hesCode, int adminId) {
		super(name, surName, telNumber, emailAddress, password);
		this.isActive = isActive;
		this.HesCode = hesCode;
		this.adminId = adminId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHesCode() {
		return HesCode;
	}

	public void setHesCode(String hesCode) {
		HesCode = hesCode;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
}
