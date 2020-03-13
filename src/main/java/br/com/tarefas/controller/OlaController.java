package br.com.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaController {

	@RequestMapping("ola")
	public String ola() {
		System.out.println("Executando a lógica com Spring MVC");
		 return "ola";
	}
}
