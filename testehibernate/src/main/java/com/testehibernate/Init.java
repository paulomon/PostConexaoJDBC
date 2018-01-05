package com.testehibernate;

import com.testehibernate.dao.PessoaDAO;
import com.testehibernate.model.Pessoa;
import com.testehibernate.persistence.SessionFactoryImpl;

public class Init {

	public Init() {
		
		Runnable r1 = () -> {
			System.out.println("R1 - Abrindo sessão: " + SessionFactoryImpl.getSession().hashCode());
			Pessoa pessoa = new Pessoa("Maria");
			PessoaDAO pessoaDao = new PessoaDAO();
			pessoaDao.persist(pessoa);
			System.out.println("R1 - Fechando sessão: " + SessionFactoryImpl.getSession().hashCode());
			SessionFactoryImpl.getSession().getTransaction().commit();
		};
		
		Runnable r2 = () -> {
			System.out.println("R2 - Abrindo sessão: " + SessionFactoryImpl.getSession().hashCode());
			Pessoa pessoa = new Pessoa("João");
			PessoaDAO pessoaDao = new PessoaDAO();
			pessoaDao.persist(pessoa);
			System.out.println("R2 - Fechando sessão: " + SessionFactoryImpl.getSession().hashCode());
			SessionFactoryImpl.getSession().getTransaction().commit();
		};
		
		Runnable r3 = () -> {
			System.out.println("R3 - Abrindo sessão: " + SessionFactoryImpl.getSession().hashCode());
			PessoaDAO pessoaDao = new PessoaDAO();
			pessoaDao.listAll();
			System.out.println("R3 - Fechando sessão: " + SessionFactoryImpl.getSession().hashCode());
			SessionFactoryImpl.getSession().getTransaction().commit();
		};
		
		Runnable r4 = () -> {
			System.out.println("R4 - Abrindo sessão: " + SessionFactoryImpl.getSession().hashCode());
			PessoaDAO pessoaDao = new PessoaDAO();
			pessoaDao.listAll();
			System.out.println("R4 - Fechando sessão: " + SessionFactoryImpl.getSession().hashCode());
			SessionFactoryImpl.getSession().getTransaction().commit();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);

		t1.start();
		t3.start();
		t2.start();
		t4.start();
	}	
	
	public static void main(String... args) {
		new Init();
	}
	
	

}
