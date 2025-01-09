package com.hibernate.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CriteriaDelete_App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//CriteriaBuilder(I)

		//Delete operation
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Product> cd = cb.createCriteriaDelete(Product.class);
		Root<Product> root = cd.from(Product.class);
		//cu.set(root.get("productPrice"), 123456789);
		cd.where(cb.equal(root.get("productId"), 1));
		
		//Executing the query constructed by crietriaQuery
		Query<Product> query = session.createQuery(cd);
		int result = query.executeUpdate();
		System.out.println(result);
			
		
	
		tran.commit();
		session.close();
		sf.close();


	}
}
