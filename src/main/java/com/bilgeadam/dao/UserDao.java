package com.bilgeadam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.dto.UserDto;

public class UserDao implements IDAOImplements<UserDto> {

	@Override
	public void create(UserDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "INSERT INTO user_blog "
					+ "(user_name, user_surname, user_tel_number, user_email_address, user_password, user_is_active, user_hescode, admin_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getSurName());
			preparedStatement.setString(3, dto.getTelNumber());
			preparedStatement.setString(4, dto.getEmailAddress());
			preparedStatement.setString(5, dto.getPassword());
			preparedStatement.setBoolean(6, dto.isActive());
			preparedStatement.setString(7, dto.getHesCode());
			preparedStatement.setInt(8, dto.getAdminId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Ekleme başarılı.");
			} else {
				System.out.println("Ekleme sırasında bir hata oluştu.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " UserDao create hata meydana geldi.");
		}

	}

	@Override
	public void update(UserDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "UPDATE user_blog SET user_name =?, user_surname =?, user_tel_number =?, user_email_address =?, user_password =?, "
					+ "user_is_active =?, user_hescode =?, admin_id =? WHERE user_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getSurName());
			preparedStatement.setString(3, dto.getTelNumber());
			preparedStatement.setString(4, dto.getEmailAddress());
			preparedStatement.setString(5, dto.getPassword());
			preparedStatement.setBoolean(6, dto.isActive());
			preparedStatement.setString(7, dto.getHesCode());
			preparedStatement.setInt(8, dto.getAdminId());
			preparedStatement.setInt(9, dto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Güncelleme başarılı.");
			} else {
				System.out.println("Güncelleme sırasında bir hata oluştu.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " UserDao update hata meydana geldi.");
		}

	}

	@Override
	public void delete(UserDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "DELETE FROM user_blog WHERE user_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dto.getId());

			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Silme başarılı.");
			} else {
				System.out.println("Silme sırasında bir hata oluştu.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " UserDao delete hata meydana geldi.");
		}

	}

	@Override
	public ArrayList<UserDto> list() {
		ArrayList<UserDto> list2 = new ArrayList<UserDto>();
		UserDto userDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "SELECT * FROM user_blog";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				userDto = new UserDto();
				userDto.setId(set.getInt("user_id"));
				userDto.setName(set.getString("user_name"));
				userDto.setSurName(set.getString("user_surname"));
				userDto.setTelNumber(set.getString("user_tel_number"));
				userDto.setEmailAddress(set.getString("user_email_address"));
				userDto.setPassword(set.getString("user_password"));
				userDto.setActive(set.getBoolean("user_is_active"));
				userDto.setHesCode(set.getString("user_hescode"));
				userDto.setAdminId(set.getInt("admin_id"));
				userDto.setCreateDate(set.getDate("created_date"));
				list2.add(userDto);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " UserDao list hata meydana geldi.");
		}
		return list2;
	}
}
