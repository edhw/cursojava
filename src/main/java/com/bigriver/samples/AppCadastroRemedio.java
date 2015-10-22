package com.bigriver.samples;

import com.bigriver.samples.dao.RemedioDAO;
import com.bigriver.samples.model.Remedio;
import com.bigriver.samples.view.TelaCadastro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Janela de Cadastro de Remedios da Aplicação
 * @author Rodney
 *
 */
public class AppCadastroRemedio extends Application {
	 public static void main( String[] args ){
	    	//Inicializa a aplicação JavaFX
	    	launch();
	    
	    }

		@Override
		public void start(Stage primaryStage) throws Exception {
			//Carrega um objeto de Remedio
			Remedio remedio = new Remedio();

			//Carrega um DAO de Remedio
			RemedioDAO dao = new RemedioDAO();
			//Cria uma tela de cadastro de Remedios
			TelaCadastro<Remedio> cadastro = new TelaCadastro<>("Cadastro Remédios", remedio, dao);
			
			//Cria a Scene (JavaFX) com a tela de Cadastro
			Scene scene = new Scene(cadastro);
			//Cria a Tela
			primaryStage.setScene(scene);
			//Mostra a Tela
			primaryStage.show();
			
			//Quando fechar a aplicação, garante que
			primaryStage.setOnCloseRequest(evt -> {
				//Fecha todas as conexões com a base de dados
				BancoDeDados.closeFactory();
			});
		}

}
