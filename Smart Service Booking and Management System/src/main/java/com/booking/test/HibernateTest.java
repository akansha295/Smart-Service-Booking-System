package com.booking.test;


	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

	public class HibernateTest {
		public static void main (String [] args)
		{
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	     Session session = factory.openSession() ;
	     Transaction tx = session.beginTransaction();
	     
		
		}
	}
