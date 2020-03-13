package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.tarefas.modelo.Cliente;

@Repository
public class JpaClienteDAO implements ClienteDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	public Cliente buscaPOrId(Long id) {
		
		return entityManager.find(Cliente.class, id);
	}

	public List<Cliente> lista() {
		
		return entityManager.createQuery("select c from Cliente c").getResultList();
	}

	public void adicona(Cliente cliente) {
		entityManager.persist(cliente);
		
	}

	public void atualiza(Cliente cliente) {
		entityManager.merge(cliente);
		
	}

	public void remove(Cliente cliente) {
		Cliente cliente2 = buscaPOrId(cliente.getId());
		entityManager.remove(cliente2);
		
	}

}
