package com.testehibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = {
		@NamedQuery(
				name = "Pessoa.listAll",
				query = "select p from Pessoa p"
		)
})
@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(columnDefinition = "varchar(80)")
	private String nome;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %s Nome: %s", id, nome);
	}
	
}
