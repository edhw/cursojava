package com.bigriver.samples.service;

import java.util.Collection;

import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.model.*;

public class VendaRemedio implements ServicoVenda<Remedio>{
	//Um atributo primário para busca de remedios
	private RemedioDAO daoR;

	public VendaRemedio() {
		this.daoR = new RemedioDAO();
	}
	
	@Override
	public Collection<Remedio> todosNaoVendidos() {
		//Consultar todas os remedios do banco de dados.
		//Alterar para uma busca de produtos/itens não vendidos.
		return daoR.todos();
	}

	@Override
	public void vender(Remedio produto, Pessoa cliente) {
		//Implementar uma lógica para a venda de um produto
		System.out.format("Vendeu o remedio %s, para %s", produto, cliente);
	}	
	
/*	@OneToOne 
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
//	@OneToOne 
	public Remedio getRemedio() {
		return remedio;
	}
	
	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}*/
}
