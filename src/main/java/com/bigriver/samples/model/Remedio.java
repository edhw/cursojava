package com.bigriver.samples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dooapp.fxform.annotation.NonVisual;


/**
 * Classe da tabela Pessoa do Banco de Dados.
 * @author Karla
 *
 */
@Entity
//@EntityListeners(RemedioListener.class)
public class Remedio {
	@NonVisual
	private int id;
	
	private String nome;
	private String validade;
	private String tarja;
	private Float preco;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	public String getTarja() {
		return tarja;
	}
	
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
	
	public Float getPreco() {
		return preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}	
	
	@Override
	public String toString() {
		return ("Nome: "+ nome +"\nValidade :" + validade + "\nTarja: " + tarja + "\nPreco: " + preco);
	}
	
}
