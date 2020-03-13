package br.com.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tarefas.modelo.Cliente;

public class CarregaCliente {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager entityManager = factory.createEntityManager();
		
		Cliente clienteEncontrado = entityManager.find(Cliente.class, 2l);
		
		System.out.println("Encontrado - " + clienteEncontrado.getNome());
	}
}
