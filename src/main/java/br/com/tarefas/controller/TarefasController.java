package br.com.tarefas.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private static final String TELA_NOVA_TAREFA = "tarefa/formulario";
	private static final String TELA_ADICIONA = "tarefa/adicionado";
	private static final String TELA_LISTA = "tarefa/lista";
	
	private TarefaDAO dao;
	
	@Autowired
	public TarefasController(TarefaDAO dao) {
		this.dao = dao;
	}
	@RequestMapping("novaTarefa")
	public String form() {
		System.out.println("Acessando o formulario de cadastro");
		
		return TELA_NOVA_TAREFA;
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult bindingResult) {
		
		if(bindingResult.hasFieldErrors("descricao")) {
			return TELA_NOVA_TAREFA;
		}
		tarefa.setFinalizada(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		dao.adiciona(tarefa);
		System.out.println("Adiconado no banco de dados com sucesso!");
		return TELA_ADICIONA;
	}
	
	@RequestMapping("listaTarefa")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return TELA_LISTA;
	}
	
	@RequestMapping("removeTarefa")
	public String remover(Tarefa tarefa) {
		dao.remover(tarefa);
		
		return "redirect:listaTarefa";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		dao.altera(tarefa);
		
		return "redirect:listaTarefa";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		dao.finaliza(id);
	}
}
