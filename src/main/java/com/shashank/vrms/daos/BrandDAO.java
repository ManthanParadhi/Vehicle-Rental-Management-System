package com.shashank.vrms.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.shashank.vrms.models.Brand;

public class BrandDAO {

	Connection con = null;
	
	public BrandDAO() throws SQLException, ClassNotFoundException {
		 //this.con = HikariCPDataSource.getConnection();
		String url = "jdbc:mysql://localhost:3306/vehicle_rental_management_system";
		String username = "root";
		String password = "000000";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
	}
	
	public void addBrand(String brandName) throws SQLException {
		
		
		final String query = "insert into brand(brand_name,created_on) values(?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, brandName);
		pst.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
		pst.executeUpdate();
				
	}
	
	
	public List<Brand> getAllBrands() throws SQLException{
		final String query =  "select * from brand";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		List<Brand> brandList = new ArrayList<>();
		while(rs.next()) {
			Brand brand = new Brand(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getTimestamp(4));
			brandList.add(brand);
		}
		return brandList;
	}
	
	
	public void deleteBrand(int id) throws SQLException {
		
		final String query = "delete from brand WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.executeUpdate();
	}
	
	public Brand getBrandById(int id) throws SQLException {
		String query = "select * from brand WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		Brand brand = new Brand(id,rs.getString(2),rs.getTimestamp(3),rs.getTimestamp(4));
		return brand;
	}
	
	
	public void updateBrand(Brand brand) throws SQLException {
		
			String query = "UPDATE brand set brand_name=?,updated_on=? WHERE id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,brand.getBrand());
			pst.setTimestamp(2,brand.getUpdatedOn());
			pst.setInt(3,brand.getId());
			pst.executeUpdate();	
			
	}
}
