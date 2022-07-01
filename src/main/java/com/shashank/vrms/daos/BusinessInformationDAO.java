package com.shashank.vrms.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shashank.vrms.models.BusinessInformation;

public class BusinessInformationDAO {
	Connection con = null;
	
	public BusinessInformationDAO() throws SQLException, ClassNotFoundException {
		 //this.con = HikariCPDataSource.getConnection();
		String url = "jdbc:mysql://localhost:3306/vehicle_rental_management_system";
		String username = "root";
		String password = "000000";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
	}
	
	public BusinessInformation getBusinessInformation() throws SQLException {
		
		final String query = "select * from business_information";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		BusinessInformation information = new BusinessInformation();
		information.setId(rs.getInt(1));
		information.setBusinessName(rs.getString(2));
		information.setBusinessAddress(rs.getString(3));
		information.setBusinessEmail(rs.getString(4));
		information.setBusinessContactNumber(rs.getString(5));
		
		return information;
	}
	
	public void addBusinessInformation(BusinessInformation information ) throws SQLException {
		
		final String query = "insert into business_information(business_name,business_address,business_email,business_contact_number) "
				+ "values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, information.getBusinessName());
		pst.setString(2, information.getBusinessAddress());
		pst.setString(3, information.getBusinessEmail());
		pst.setString(4, information.getBusinessContactNumber());
		
		pst.executeUpdate();
	}
	
	public void updateBusinessInformation(BusinessInformation information ) throws SQLException {
		
		final String query = "UPDATE business_information set business_name=?,business_address=?,business_email=?,"
				+ "business_contact_number=? WHERE id=?";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, information.getBusinessName());
		pst.setString(2, information.getBusinessAddress());
		pst.setString(3, information.getBusinessEmail());
		pst.setString(4, information.getBusinessContactNumber());
		pst.setInt(5, information.getId());
		
		pst.executeUpdate();
	}
	
public boolean isBusinessInformationPresent() throws SQLException {
		
		final String query = "select count(*) from business_information";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		int count = rs.getInt(1);
		if(count == 0)
			return false;
		return true;
	}
}
