package com.testehibernate.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.testehibernate.model.Pessoa;

public class SessionFactoryImpl {

	private static SessionFactory sessionFactory;

	public synchronized static Session getSession() {
		if (sessionFactory == null) {
			Configuration conf = new Configuration();
			sessionFactory = conf.addAnnotatedClass(Pessoa.class).buildSessionFactory();
		}
		return sessionFactory.getCurrentSession();
	}
}
