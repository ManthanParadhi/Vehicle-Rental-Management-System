package com.shashank.vrms.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mysql.cj.jdbc.BlobFromLocator;
import com.mysql.cj.protocol.Resultset;
import com.shashank.vrms.enums.VehicleType;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.models.VehicleDocuments;
import com.shashank.vrms.utilities.HibernateUtil;

public class VehicleDAO {

	

	public void addVehicle(Vehicle vehicle)  {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

	}

	public List<Vehicle> getAllVehicles() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Vehicle> vehicleList = loadAllData(Vehicle.class, session);
		session.getTransaction().commit();
		session.close();
		return vehicleList;

	}

	public void deleteVehicle(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object persistentInstance = session.load(Vehicle.class, id);
		if (persistentInstance != null)
			session.delete(persistentInstance);

		session.getTransaction().commit();
		session.close();

	}

	public Vehicle getVehicleById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Vehicle vehicle = session.get(Vehicle.class, id);
		session.getTransaction().commit();
		session.close();

		return vehicle;
	}

	public void updateVehicle(Vehicle vehicle) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(vehicle);
		session.getTransaction().commit();
		session.close();

	}

	public void switchVehicleAvalability(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Vehicle vehicle = session.get(Vehicle.class, id);
		vehicle.setAvailable(!vehicle.isAvailable());
		session.update(vehicle);
		session.getTransaction().commit();
		session.close();

	}

	private static <T> List<T> loadAllData(Class<T> type, Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		List<T> data = session.createQuery(criteria).getResultList();
		return data;
	}

}
