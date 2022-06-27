package com.shashank.vrms.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shashank.vrms.models.User;
import com.shashank.vrms.utilities.HikariCPDataSource;

public class UserDAO {

	Connection con = null;
	
	public UserDAO() throws SQLException, ClassNotFoundException {
		 //this.con = HikariCPDataSource.getConnection();
		String url = "jdbc:mysql://localhost:3306/vehicle_rental_management_system";
		String username = "root";
		String password = "000000";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
	}

	public boolean registerUser(User user) {

		try {
			String query = "insert into users(first_name,last_name,email,password,role,created_on,updated_on) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getRole().toString());
			pst.setTimestamp(6, user.getCreatedOn());
			pst.setTimestamp(7, user.getUpdatedOn());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isEmailAlreadyTaken(User user) throws SQLException {
		final String query =  "select count(*) from users WHERE email=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,user.getEmail());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		boolean isEmailPresent = false;
		if(count == 1) {
			isEmailPresent = true;
			return isEmailPresent;
		}
		return isEmailPresent;	
	}
}
