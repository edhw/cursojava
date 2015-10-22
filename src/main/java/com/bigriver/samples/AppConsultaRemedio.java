package com.bigriver.samples;

import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.model.Remedio;
import com.bigriver.samples.view.TelaConsulta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Janela de Consulta de Remédios da Aplicação
 * @author Rodney
 *
 */
public class AppConsultaRemedio extends Application {
	public static void main(String[] args) {
		//Inicializa a aplicação JavaFX
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Cria um DAO para as Pessoas
		RemedioDAO remedioDao = new RemedioDAO();
		//Cria uma Tela de Consulta de Pessoas
		TelaConsulta<Remedio> consulta = new TelaConsulta<>("Remedios", remedioDao);
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
