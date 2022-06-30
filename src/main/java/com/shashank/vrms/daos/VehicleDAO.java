package com.shashank.vrms.daos;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.BlobFromLocator;
import com.mysql.cj.protocol.Resultset;
import com.shashank.vrms.enums.VehicleType;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.models.VehicleDocuments;

public class VehicleDAO {
	Connection con = null;

	public VehicleDAO() throws SQLException, ClassNotFoundException {
		// this.con = HikariCPDataSource.getConnection();
		String url = "jdbc:mysql://localhost:3306/vehicle_rental_management_system";
		String username = "root";
		String password = "000000";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
	}

	public void addVehicle(Vehicle vehicle) throws SQLException {
		final String query = "insert into vehicles(model,variant,color,reg_number,reg_year,engine_number,chasis_number,brand_id,seating_capacity,is_available,created_on,image_url,vehicle_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,vehicle.getModel());
		pst.setString(2,vehicle.getVariant());
		pst.setString(3,vehicle.getColor());
		pst.setString(4,vehicle.getRegistrationNumber());
		pst.setString(5,vehicle.getRegistrationYear());
		pst.setString(6,vehicle.getEngineNumber());
		pst.setString(7,vehicle.getChasisNumber());
		pst.setInt(8,vehicle.getBrandId());
		pst.setInt(9,vehicle.getSeatingCapacity());
		pst.setBoolean(10,vehicle.isAvailable());
		pst.setTimestamp(11,vehicle.getCreatedOn());
		pst.setString(12,vehicle.getImageUrl());
		pst.setString(13,vehicle.getType().toString());
		
		pst.executeUpdate();																										

	}
	
	public void  addVehicleDocuments(Vehicle vehicle) throws SQLException {
		
		System.out.println(vehicle);
		final String query = "insert into vehicle_documents(reg_expires_on,puc_expires_on,insurance_expires_on,vehicle_id,created_on) values(?,?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setTimestamp(1,vehicle.getDocuments().getRegExpiresOn());
		pst.setTimestamp(2,vehicle.getDocuments().getPucExpiresOn());
		pst.setTimestamp(3,vehicle.getDocuments().getInsuranceExpiresOn());
		pst.setInt(4,getVehicleIdByRegNumber(vehicle.getRegistrationNumber()));
		pst.setTimestamp(5,vehicle.getDocuments().getCreatedOn());
		
		pst.executeUpdate();
	}
	
	public int getVehicleIdByRegNumber(String regNumber) throws SQLException {
		final String query = "select id from vehicles WHERE reg_number=?";	
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, regNumber);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int vehicleId = rs.getInt(1);
		return vehicleId;
		
	}
	
	
	
	public List<Vehicle> getAllVehicles() throws SQLException{
		final String query =  "select * from vehicles";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		List<Vehicle> vehicleList = new ArrayList<>();
		while(rs.next()) {
			Vehicle vehicle  = new Vehicle();
			vehicle.setId(rs.getInt(1));
			vehicle.setModel(rs.getString(2));
			vehicle.setVariant(rs.getString(3));
			vehicle.setColor(rs.getString(4));
			vehicle.setRegistrationNumber(rs.getString(5));
			vehicle.setRegistrationYear(rs.getString(6));
			vehicle.setEngineNumber(rs.getString(7));
			vehicle.setChasisNumber(rs.getString(8));
			vehicle.setBrandId(rs.getInt(9));
			vehicle.setSeatingCapacity(rs.getInt(10));
			vehicle.setAvailable(rs.getBoolean(11));
			vehicle.setCreatedOn(rs.getTimestamp(12));
			vehicle.setUpdatedOn(rs.getTimestamp(13));
			vehicle.setImageUrl(rs.getString(14));
			vehicle.setType(VehicleType.valueOf(rs.getString(15)));
			vehicle.setDocuments(getVehiclesDocuments(rs.getInt(1)));
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}
	
	public VehicleDocuments getVehiclesDocuments(int vehicleId) throws SQLException{
		
		final String query = "Select * from vehicle_documents WHERE vehicle_id = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, vehicleId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		VehicleDocuments documents = new VehicleDocuments();
		documents.setId(rs.getInt(1));
		documents.setRegExpiresOn(rs.getTimestamp(2));
		documents.setPucExpiresOn(rs.getTimestamp(3));
		documents.setInsuranceExpiresOn(rs.getTimestamp(4));
		documents.setVehicleId(rs.getInt(5));
		documents.setCreatedOn(rs.getTimestamp(6));
		documents.setUpdatedOn(rs.getTimestamp(7));
		
		return documents;
		
	}
	
	public void deleteVehicle(int id) throws SQLException {
		
		final String deleteVehicle  = "delete from vehicles WHERE id = ?";
		final String deleteVehicleDocuments = "delete from vehicle_documents WHERE vehicle_id = ?";
		PreparedStatement pstVehicleDocuments = con.prepareStatement(deleteVehicleDocuments);
		PreparedStatement pstVehicle = con.prepareStatement(deleteVehicle);
		pstVehicleDocuments.setInt(1, id);
		pstVehicle.setInt(1, id);
		pstVehicleDocuments.executeUpdate();
		pstVehicle.executeUpdate();
	}
	
	public Vehicle getVehicleById(int id) throws SQLException {
		
		final String query = "select * from vehicles WHERE id= ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		Vehicle vehicle  = new Vehicle();
		
		vehicle.setId(rs.getInt(1));
		vehicle.setModel(rs.getString(2));
		vehicle.setVariant(rs.getString(3));
		vehicle.setColor(rs.getString(4));
		vehicle.setRegistrationNumber(rs.getString(5));
		vehicle.setRegistrationYear(rs.getString(6));
		vehicle.setEngineNumber(rs.getString(7));
		vehicle.setChasisNumber(rs.getString(8));
		vehicle.setBrandId(rs.getInt(9));
		vehicle.setSeatingCapacity(rs.getInt(10));
		vehicle.setAvailable(rs.getBoolean(11));
		vehicle.setCreatedOn(rs.getTimestamp(12));
		vehicle.setUpdatedOn(rs.getTimestamp(13));
		vehicle.setImageUrl(rs.getString(14));
		vehicle.setType(VehicleType.valueOf(rs.getString(15)));
		vehicle.setDocuments(getVehiclesDocuments(id));
		
		return vehicle;
		
	}
	
	public void updateVehicle(Vehicle vehicle) throws SQLException {
		
		final String query = "UPDATE vehicles set model=?,variant=?,color=?,reg_number=?,reg_year=?,engine_number=?,chasis_number=?,brand_id=?,"
				+ "seating_capacity=?,is_available=?,updated_on=?,image_url=?,vehicle_type=? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,vehicle.getModel());
		pst.setString(2,vehicle.getVariant());
		pst.setString(3,vehicle.getColor());
		pst.setString(4,vehicle.getRegistrationNumber());
		pst.setString(5,vehicle.getRegistrationYear());
		pst.setString(6,vehicle.getEngineNumber());
		pst.setString(7,vehicle.getChasisNumber());
		pst.setInt(8,vehicle.getBrandId());
		pst.setInt(9,vehicle.getSeatingCapacity());
		pst.setBoolean(10,vehicle.isAvailable());
		
		pst.setTimestamp(11,vehicle.getUpdatedOn());
		pst.setString(12,vehicle.getImageUrl());
		pst.setString(13,vehicle.getType().toString());
		pst.setInt(14,vehicle.getId());
		
		pst.executeUpdate();	
		
		System.out.println("update vehicle run");
		System.out.println(vehicle.getId());
	}
	
	public void updateVehicleDocuments(Vehicle vehicle) throws SQLException {
		final String query = "UPDATE  vehicle_documents set reg_expires_on=?,puc_expires_on=?,insurance_expires_on=?,updated_on=? WHERE vehicle_id=?";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setTimestamp(1,vehicle.getDocuments().getRegExpiresOn());
		pst.setTimestamp(2,vehicle.getDocuments().getPucExpiresOn());
		pst.setTimestamp(3,vehicle.getDocuments().getInsuranceExpiresOn());
		
		pst.setTimestamp(4,vehicle.getDocuments().getUpdatedOn());
		pst.setInt(5,vehicle.getDocuments().getId());
		
		pst.executeUpdate();
	}
	
	public void switchVehicleAvalability(int id) throws SQLException {
		
		final String checkAvailabilityQuery = "select is_available from vehicles WHERE id = ?";
		final String changeAvailabilityQuery = "Update vehicles set is_available = ? WHERE id = ?";
		
		PreparedStatement pstcheckAvailabilityQuery = con.prepareStatement(checkAvailabilityQuery);
		pstcheckAvailabilityQuery.setInt(1, id);
		ResultSet rs = pstcheckAvailabilityQuery.executeQuery();
		rs.next();
		boolean isAvailable = rs.getBoolean(1);
				
		PreparedStatement pstchangeAvailabilityQuery = con.prepareStatement(changeAvailabilityQuery);
		pstchangeAvailabilityQuery.setBoolean(1, !isAvailable);
		pstchangeAvailabilityQuery.setInt(2, id);
		
		pstchangeAvailabilityQuery.executeUpdate();
	}
	
	
	
	
}
