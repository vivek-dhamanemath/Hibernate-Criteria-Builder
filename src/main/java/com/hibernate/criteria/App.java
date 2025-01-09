package com.hibernate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	public static void main( String[] args )
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//CriteriaBuilder(I)

		//1.fetch operation
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
	
		//cq.where(cb.equal(root.get("productId"), 1));
		//cq.where(cb.gt(root.get("productId"), 1));
		//cq.where(cb.lt(root.get("productId"), 4))
		//cq.where(cb.like(root.get("productName"),"watch"));
		//cq.where(cb.between(root.get("productId"), 1, 4));
		
		
		//Executing the query constructed by CriteriaQuery
		Query<Product> query = session.createQuery(cq);
		List<Product> products = query.list();
		for(Product product:products) {
			System.out.println(product);
			//System.out.println(product.getProductId());
			//System.out.println(product.getProductName());
			//System.out.println(product.getProductBrand());
			//System.out.println(product.getProductPrice());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		tran.commit();
		session.close();
		sf.close();


	}
}
