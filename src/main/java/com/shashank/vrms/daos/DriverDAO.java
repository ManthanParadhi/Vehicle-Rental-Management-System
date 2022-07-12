package com.shashank.vrms.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.shashank.vrms.enums.AvailabilityStatus;
import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Driver;
import com.shashank.vrms.models.User;
import com.shashank.vrms.utilities.Helper;
import com.shashank.vrms.utilities.HibernateUtil;

public class DriverDAO {

	public void addDriver(Driver driver) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(driver);
		session.getTransaction().commit();
		session.close();
	}

	public Driver getDriverById(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Driver driver = session.get(Driver.class, id);
		session.getTransaction().commit();
		session.close();

		return driver;
	}

	public void updateDriver(Driver driver) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(driver);
		session.getTransaction().commit();
		session.close();
	}

	public List<Driver> getAllDrivers() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Driver> driverList = Helper.loadAllData(Driver.class, session);
		session.getTransaction().commit();
		session.close();

		return driverList;
	}

	public void deleteDriver(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object persistentInstance = session.load(Driver.class, id);
		if (persistentInstance != null)
			session.delete(persistentInstance);

		session.getTransaction().commit();
		session.close();
	}
	
	
}
