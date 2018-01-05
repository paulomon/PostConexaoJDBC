package com.testehibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.testehibernate.model.Pessoa;
import com.testehibernate.persistence.SessionFactoryImpl;

public class PessoaDAO {

	private Session session;

	{
		session = SessionFactoryImpl.getSession();
	}

	public List<Pessoa> listAll() {
		session.beginTransaction();
		Query<Pessoa> query = session.createNamedQuery("Pessoa.listAll", Pessoa.class);
		return query.getResultList();
	}

	public void persist(Pessoa p) {
		session.beginTransaction();
		session.persist(p);
	}

}
