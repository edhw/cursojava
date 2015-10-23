package com.bigriver.samples.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dooapp.fxform.annotation.NonVisual;

@Entity
public class Venda {
	@NonVisual
	private int id;
	private Pessoa cliente;
	private Remedio remedio;
	//Não exibir em formulários
	@NonVisual
	private Date timestamps;

	@OneToOne 
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	@OneToOne 
	public Remedio getRemedio() {
		return remedio;
	}
	
	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
		this.remedio.setVendido(true);
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamps() {
		return timestamps;
	}
	
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}
	
	@Override
	public String toString() {
		return ("Cliente: " + cliente + "\nProduto: " + remedio + " Data: " + timestamps);
	}
}
