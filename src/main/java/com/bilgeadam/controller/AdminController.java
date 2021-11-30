package com.bilgeadam.controller;

import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dao.IDAOImplements;
import com.bilgeadam.dto.AdminDto;

public class AdminController implements IDAOImplements<AdminDto> {

	private AdminDto adminDto;
	private AdminDao adminDao;
	private List<AdminDto> adminList;

	public AdminController() {
		this.adminDto = new AdminDto();
		this.adminDao = new AdminDao();
		this.adminList = new ArrayList<AdminDto>();
	}

	@Override
	public void create(AdminDto dto) {
		adminDao.create(dto);

	}

	@Override
	public void update(AdminDto dto) {
		adminDao.update(dto);

	}

	@Override
	public void delete(AdminDto dto) {
		adminDao.delete(dto);

	}

	@Override
	public ArrayList<AdminDto> list() {
		return adminDao.list();
	}

	public AdminDto getAdminDto() {
		return adminDto;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<AdminDto> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<AdminDto> adminList) {
		this.adminList = adminList;
	}

}
