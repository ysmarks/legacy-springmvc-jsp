package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.modelo.Cliente;

public interface ClienteDAO {

	Cliente buscaPOrId(Long id);
	List<Cliente> lista();
	void adicona(Cliente cliente);
	void atualiza(Cliente cliente);
	void remove(Cliente cliente);
	
}
