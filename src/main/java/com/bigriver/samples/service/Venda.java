package com.bigriver.samples.service;

import javax.persistence.OneToOne;

import com.bigriver.samples.model.*;

public class Venda {
	private Pessoa cliente;
	private Remedio remedio;
	
	public Venda (){
		
	}
	
	public void mostrarDados(){
		
	}
//	@OneToOne 
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
	}
	
	
	
}
