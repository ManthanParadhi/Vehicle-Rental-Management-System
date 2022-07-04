package com.shashank.vrms.daos;




import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.shashank.vrms.models.Brand;
import com.shashank.vrms.models.Vehicle;
import com.shashank.vrms.utilities.HibernateUtil;

public class BrandDAO {


	
	public void addBrand(String brandName)  {
		
		Brand brand = new Brand();
		brand.setBrand(brandName);
		brand.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		session.close();
		
				
	}
	
	
	public List<Brand> getAllBrands() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Brand> brandList = loadAllData(Brand.class, session);
		session.getTransaction().commit();
		session.close();
		
		return brandList;
	}
	
	
	public void deleteBrand(int id)  {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object persistentInstance = session.load(Brand.class, id);
		if (persistentInstance != null)
			session.delete(persistentInstance);

		session.getTransaction().commit();
		session.close();
	}
	
	
	
	
	public void updateBrand(Brand brand)  {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(brand);
		session.getTransaction().commit();
		session.close();			
	}
	
	public Brand getBrandById(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, id);
		session.getTransaction().commit();
		session.close();

		return brand;
	}
	
	private static <T> List<T> loadAllData(Class<T> type, Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		List<T> data = session.createQuery(criteria).getResultList();
		return data;
	}
}
