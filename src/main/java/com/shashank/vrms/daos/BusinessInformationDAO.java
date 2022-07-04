package com.shashank.vrms.daos;

import java.util.List;

import org.hibernate.Session;

import com.shashank.vrms.models.BusinessInformation;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.utilities.Helper;
import com.shashank.vrms.utilities.HibernateUtil;

public class BusinessInformationDAO {

	public BusinessInformation getBusinessInformation() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BusinessInformation> informationList = Helper.loadAllData(BusinessInformation.class, session);
		session.getTransaction().commit();
		
		BusinessInformation information = informationList.get(0);
		
		session.close();
		

		return information;
	}

	public void addBusinessInformation(BusinessInformation information) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(information);
		session.getTransaction().commit();
		session.close();

	}

	public void updateBusinessInformation(BusinessInformation information) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(information);
		session.getTransaction().commit();
		session.close();
	}

	public boolean isBusinessInformationPresent() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BusinessInformation> informationList = Helper.loadAllData(BusinessInformation.class, session);
		session.getTransaction().commit();
		session.close();
		if(informationList.isEmpty())
			return false;
		return true;

	}
}
