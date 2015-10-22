package com.bigriver.samples.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.bigriver.samples.BancoDeDados;
import com.bigriver.samples.model.Remedio;

/**
 * Operações básicas do BD na tabela Remedio
 * @author Karla
 *
 */
public class RemedioDAO implements DAO<Remedio>{
		
		/**
		 * Salvar uma ocorrência de Remedio no Banco de Dados
		 * @param objeto A ocorrência que deverá ser salva
		 * @return A pessoa que foi salva
		 */
		
		@Override
		public Remedio salvar(Remedio objeto) {
			//Abre um gerente de entidades
			EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
			//Abre uma transação com o BD
			gerenteEntidades.getTransaction().begin();
			//Guarda o Objeto no BD
			gerenteEntidades.persist(objeto);
			//Conclui a transação com o BD, garantindo a execução da operação
			gerenteEntidades.getTransaction().commit();
			//Fecha o Gerente de Entidades, concluindo o ciclo de vida de operações
			gerenteEntidades.close();
			
			return objeto;
		}
		
		/**
		 * Buscar uma ocorrência de Remedio no Banco de Dados
		 * @param id O identificador único do remédio que será buscado
		 * @return o remédio encontrado
		 */
		
		@Override
		public Remedio buscar(int id) {
			//Abre um gerente de entidades
			EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
			//Abre uma transação com o BD
			gerenteEntidades.getTransaction().begin();		
			//Busca uma pessoa no BD pelo ID - X
			Remedio busca = gerenteEntidades.find(Remedio.class, id);
			//Conclui a transação com o BD, garantindo a execução da operação
			gerenteEntidades.getTransaction().commit();

			gerenteEntidades.close();
			
			return busca;
		}
		
		/**
		 * Coletar todas as ocorrências de remédio do Banco de Dados
		 * @return Uma coleção com todas as ocorrências de remédio
		 */
		@Override
		public Collection<Remedio> todos() {
			
			EntityManager gerenteEntidades = BancoDeDados.abreEntityManager();
			gerenteEntidades.getTransaction().begin();
			//Cria uma QUERY que buscará TODAS as Pessoas no BD
			@SuppressWarnings("unchecked")
			Collection<Remedio> todos = gerenteEntidades.createQuery("from Remedio")
					.getResultList();
			//Garante a conclusão da operação
			gerenteEntidades.getTransaction().commit();
			gerenteEntidades.close();
			
			return todos;
		}

}
