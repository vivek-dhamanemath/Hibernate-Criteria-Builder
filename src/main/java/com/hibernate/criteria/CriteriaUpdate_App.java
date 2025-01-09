package com.hibernate.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CriteriaUpdate_App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//CriteriaBuilder(I)

		//Update operation
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Product> cu = cb.createCriteriaUpdate(Product.class);
		Root<Product> root = cu.from(Product.class);
		cu.set(root.get("productPrice"), 123456789);
		cu.where(cb.equal(root.get("productId"), 1));
		
		//Executing the query constructed by crietriaQuery
		Query<Product> query = session.createQuery(cu);
		int result = query.executeUpdate();
		System.out.println(result);
			
		
	
		tran.commit();
		session.close();
		sf.close();


	}
}
