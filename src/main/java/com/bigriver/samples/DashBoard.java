package com.bigriver.samples;

import com.bigriver.samples.dao.PessoaDAO;
import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.model.Endereco;
import com.bigriver.samples.model.Pessoa;
import com.bigriver.samples.model.Remedio;
import com.bigriver.samples.service.VendaPessoa;
import com.bigriver.samples.service.VendaRemedio;
import com.bigriver.samples.view.TelaCadastro;
import com.bigriver.samples.view.TelaConsulta;
import com.bigriver.samples.view.TelaDashboard;
import com.bigriver.samples.view.TelaVendas;
import com.guigarage.flatterfx.FlatterFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashBoard extends Application {
	//Titulo da Janela
	static final String TITULO = "Venda de Produtos";
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Carrega um objeto Pessoa e Endereço
		Pessoa pessoa = new Pessoa();
		Endereco endereco = new Endereco();
		pessoa.setEndereco(endereco);
		
		//Carrega um DAO de Pessoas
		PessoaDAO dao = new PessoaDAO();
		//Cria uma tela de cadastro de Pessoas
		TelaCadastro<Pessoa> cadastro = new TelaCadastro<>("Cadastro Pessoa", pessoa, dao, endereco);
	
		//Cria um DAO para as Pessoas
		PessoaDAO pessoaDao = new PessoaDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Pessoa> consulta = new TelaConsulta<>("Consulta Pessoas", pessoaDao);
		
		//Cria uma Venda Ilegal de Pessoas
		VendaPessoa vendaPessoas = new VendaPessoa();
		
		//Cria uma Tela de Vendas
		TelaVendas<Pessoa> telaVendas = new TelaVendas<>("Venda Ilegal Pessoas", vendaPessoas);
		
		
		//carrega um objeto de Remedio
		Remedio remedio = new Remedio();
		//cria dao para Remedio
		RemedioDAO daoR = new RemedioDAO();
		//cria tela de cadastro de Remedio
		TelaCadastro<Remedio> cadastroRemedio = new TelaCadastro<>("Cadastro de Remedio", remedio, daoR);

		//Cria um DAO para Remedio
		RemedioDAO remedioDao = new RemedioDAO();
		//Cria uma tela de consulta de remedio
		TelaConsulta<Remedio> consultaRemedio = new TelaConsulta<>("Consulta de Remedios", remedioDao);
		
		
		//Cria uma Venda de remedios
		VendaRemedio vendaRemedio = new VendaRemedio();
				
		//Cria uma Tela de Vendas
		TelaVendas<Remedio> telaVendasRemedios = new TelaVendas<>("Venda Remédios", vendaRemedio);
		
		//Cria uma tela de DashBoard com as telas de Consulta e Cadastro de Pessoas
		TelaDashboard telaDashboard = new TelaDashboard(consulta, cadastro, telaVendas,cadastroRemedio,consultaRemedio, telaVendasRemedios);
		
		//Cria uma Scene (JavaFX) com a tela de consulta
		Scene scene = new Scene(telaDashboard);
				
		//Cria uma Janela de Consulta
		primaryStage.setScene(scene);
		
		//Titulo da Aplicação
		primaryStage.setTitle(TITULO);
				
		//Abre a Janela
		primaryStage.show();
		//Quando fechar a aplicação, garante que
		primaryStage.setOnCloseRequest(evt -> {
			//Fecha todas as conexões com a base de dados
			BancoDeDados.closeFactory();
		});
		
		
		//Tema Especial para a Dashboard
		FlatterFX.style();
	}

}
