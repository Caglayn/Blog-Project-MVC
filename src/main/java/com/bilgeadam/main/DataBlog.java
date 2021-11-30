package com.bilgeadam.main;

import java.util.ArrayList;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dto.AdminDto;

public class DataBlog {

	public static void main(String[] args) {
//		UserDto userDto = new UserDto("Ali", "Can", "5321234567", "ali@ali.com", "aliali", true, "A-1234", 1);
//		UserDto userDto2 = new UserDto("Veli", "Can", "5321234789", "veli@veli.com", "veliveli", true, "A-2345", 1);
//		userDto2.setId(5);
//		UserDto userDto3 = new UserDto("Selami", "Can", "5321234123", "selami@selami.com", "selamiselami", true,
//				"A-4567", 1);
//
//		UserDao userDao = new UserDao();
//
//		userDao.delete(userDto2);
//		userDao.create(userDto);
//		userDao.create(userDto2);
//		userDao.create(userDto3);

//		AdminDto adminDto = new AdminDto("Admin1", "Admin1", "5054567896", "admin@blog.com", "adminadmin", 0);
//		adminDto.setId(1);
//		AdminDao adminDao = new AdminDao();
//		adminDao.create(adminDto);

		AdminDao adminDao = new AdminDao();
		ArrayList<AdminDto> lst = adminDao.list();
		System.out.println(lst.get(0).getCreateDate());
	}

}
