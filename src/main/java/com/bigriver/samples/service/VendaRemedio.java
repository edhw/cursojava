package com.bigriver.samples.service;


import java.util.Collection;
import java.util.Date;

import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.*;

public class VendaRemedio implements ServicoVenda<Remedio> {
	private RemedioDAO dao = new RemedioDAO();
	private VendaDAO daoV = new VendaDAO();

	@Override
	public Collection<Remedio> todosNaoVendidos() {
		return dao.todosNaoVendidos();
	}

	@Override
	public void vender(Remedio produto, Pessoa cliente) {
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setRemedio(produto);
		Date data = new Date();
		venda.setTimestamps(data);
		
		daoV.salvar(venda);
	}

}
