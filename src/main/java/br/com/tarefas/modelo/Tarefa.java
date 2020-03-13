package br.com.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 5)
	private String descricao;
	private boolean finalizada;
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFinalizacao;
	
	public Tarefa() {
		
	}

	public Tarefa(Long id, String descricao, boolean finalizada, Calendar dataFinalizacao) {
		this.id = id;
		this.descricao = descricao;
		this.finalizada = finalizada;
		this.dataFinalizacao = dataFinalizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
	
	
}
