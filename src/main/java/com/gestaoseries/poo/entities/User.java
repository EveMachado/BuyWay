package com.gestaoseries.poo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_user")

//Permite  que os objetos da classe 'user" possam ser convertidos em bytes para serem transferidos
public class User implements Serializable{

	//identificador de versão unico para a classe
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Atributos
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;

	//construtor padrão sem parametros
	public User() {
		
	}

	//construtor com parametros
	public User(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	//Getters e setters: get retorna o valor do tributo e o set modifica ou atualiza o valor
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//substitui o metodo hashcode pra que ele retone um valor hash
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//substitui o método 'equals' para comparar dois objetos 'user'. Dois objetos sao iguais se o id for igual
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
