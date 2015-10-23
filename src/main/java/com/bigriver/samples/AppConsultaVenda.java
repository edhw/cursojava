package com.bigriver.samples;

import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.dao.VendaDAO;
import com.bigriver.samples.model.Remedio;
import com.bigriver.samples.model.Venda;
import com.bigriver.samples.view.TelaConsulta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppConsultaVenda extends Application  {
	public static void main(String[] args) {
		//Inicializa a aplicação JavaFX
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Cria um DAO para as Pessoas
		VendaDAO vendaDao = new VendaDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Venda> consulta = new TelaConsulta<>("Vendas", vendaDao);
		//Cria uma Scene (JavaFX) com a tela de consulta
		Scene scene = new Scene(consulta);
		
		//Cria uma Janela de Consulta
		primaryStage.setScene(scene);
		//Abre a Janela
		primaryStage.show();
		//Quando fechar a aplicação, garante que
		primaryStage.setOnCloseRequest(evt -> {
			//Fecha todas as conexões com a base de dados
			BancoDeDados.closeFactory();
		});
	}
}
