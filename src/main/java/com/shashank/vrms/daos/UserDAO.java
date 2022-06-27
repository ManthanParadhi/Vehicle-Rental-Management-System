package com.shashank.vrms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

	Connection con = null;

	public boolean registerUser(UserDAO user) {

		try {
			String query = "insert into users(firstName,lastName,email,password,role,creates_on,updated_on) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setString(5, user);
			pst.setString(6, user);
			pst.setString(7, user);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
