/**
 * 
 */
package com.blogrecette.tests;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.blogrecette.model.Cni;
import com.blogrecette.model.Membre;

class TestHibernate {
	protected Session session;
	protected SessionFactory sessionFactory;

	public static void main(String args[]) throws Exception {

		Transaction tx = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sessionFactory = sf;
		Session session = sessionFactory.openSession();
		tx = session.beginTransaction();


		sessionFactory.close();



	}

}


