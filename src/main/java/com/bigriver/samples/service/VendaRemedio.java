package com.bigriver.samples.service;

import java.util.Collection;

import com.bigriver.samples.dao.PessoaDAO;
import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.*;

public class VendaRemedio implements ServicoVenda<Remedio> {

	@Override
	public Collection<Remedio> todosNaoVendidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vender(Remedio produto, Pessoa cliente) {
		// TODO Auto-generated method stub
		
	}

}
