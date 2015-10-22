package com.bigriver.samples.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bigriver.samples.listener.PessoaListener;
import com.dooapp.fxform.annotation.NonVisual;


/**
 * Classe da tabela Pessoa do Banco de Dados.
 * @author Rodney
 *
 */
@Entity
@EntityListeners(PessoaListener.class)
public class Pessoa {
	//Não exibir em formulários
	@NonVisual
	private int id;
	
	private String nome;
	private int idade;
	private Venda venda;
	
	//Não exibir em formulários
	@NonVisual
	private Endereco endereco;
	
	//Não exibir em formulários
	@NonVisual
	private Date timestamps;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		return ("\nCliente: " + id + "\nNome: " + nome + "\nIdade: " + idade);
	}
	@OneToOne(mappedBy="cliente")
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
