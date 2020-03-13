package br.com.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.fabric.xmlrpc.Client;

import br.com.tarefas.modelo.Cliente;

public class AdicionaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("leao");
		cliente.setEmail("leao@email.com");
		cliente.setTelefone("5985-3865");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		System.out.println("Gerado id - " + cliente.getId());
		
		entityManager.close();
	}
}
