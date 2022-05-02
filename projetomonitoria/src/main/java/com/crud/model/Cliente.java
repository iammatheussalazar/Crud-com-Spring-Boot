package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome é de preenchimento obrigatório.")
	@Size(max = 60)
	private String nome;
	
	@NotEmpty(message = "E-mail é de preenchimento obrigatório.")
	@Email
	@Size(max = 255)
	private String email;
	
	@NotEmpty(message = "CPF é de preenchimento obrigatório.")
	private String cpf;
	
	@NotEmpty(message = "Data de nascimento é de preenchimento obrigatório.")
	private String dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private GeneroCliente generoCliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public GeneroCliente getGeneroCliente() {
		return generoCliente;
	}
	
	public void setGeneroCliente(GeneroCliente generoCliente) {
		this.generoCliente = generoCliente;
	}
	
}
