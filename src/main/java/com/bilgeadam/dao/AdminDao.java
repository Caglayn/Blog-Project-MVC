package com.bilgeadam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bilgeadam.dto.AdminDto;

public class AdminDao implements IDAOImplements<AdminDto> {

	@Override
	public void create(AdminDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "INSERT INTO admin_blog (admin_name, admin_surname, admin_tel_number, admin_email_addres, admin_password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getSurName());
			preparedStatement.setString(3, dto.getTelNumber());
			preparedStatement.setString(4, dto.getEmailAddress());
			preparedStatement.setString(5, dto.getPassword());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Ekleme başarılı.");
			} else {
				System.out.println("Ekleme sırasında bir hata oluştu.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " AdminDao create hata meydana geldi.");
		}

	}

	@Override
	public void update(AdminDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "UPDATE admin_blog SET admin_name =?, admin_surname =?, admin_tel_number =?, admin_email_addres =?, admin_password =?"
					+ " WHERE admin_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getSurName());
			preparedStatement.setString(3, dto.getTelNumber());
			preparedStatement.setString(4, dto.getEmailAddress());
			preparedStatement.setString(5, dto.getPassword());
			preparedStatement.setInt(6, dto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Güncelleme başarılı.");
			} else {
				System.out.println("Güncelleme sırasında bir hata oluştu.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " AdminDao update hata meydana geldi.");
		}

	}

	@Override
	public void delete(AdminDto dto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "DELETE FROM admin_blog WHERE admin_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dto.getId());

			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println("Silme başarılı.");
			} else {
				System.out.println("AdminDao silme hata meydana geldi.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<AdminDto> list() {
		ArrayList<AdminDto> list2 = new ArrayList<AdminDto>();
		AdminDto adminDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "SELECT * FROM admin_blog";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				adminDto = new AdminDto();
				adminDto.setId(set.getInt("admin_id"));
				adminDto.setName(set.getString("admin_name"));
				adminDto.setSurName(set.getString("admin_surname"));
				adminDto.setTelNumber(set.getString("admin_tel_number"));
				adminDto.setEmailAddress(set.getString("admin_email_addres"));
				adminDto.setPassword(set.getString("admin_password"));
				adminDto.setCreateDate(set.getDate("created_date"));
				adminDto.setRegisterNumberOfRecords(set.getInt("admin_number_of_records"));
				list2.add(adminDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

}
