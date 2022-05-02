package com.crud.model;

public enum GeneroCliente {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private final String descricao;
	
	private GeneroCliente(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
