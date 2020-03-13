package br.com.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.fabric.xmlrpc.Client;

import br.com.tarefas.modelo.Cliente;

public class BuscaClientes {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager entityManager = factory.createEntityManager();
		
		Query query = entityManager.createQuery("select c from Cliente c where c.id = :id");
		query.setParameter("id", 2l);
		
		List<Cliente> clients = query.getResultList();
		
		for (Cliente client : clients) {
			System.out.println("Cliente Encontrado - " + client.getNome());
		}
		entityManager.close();
	}
}
