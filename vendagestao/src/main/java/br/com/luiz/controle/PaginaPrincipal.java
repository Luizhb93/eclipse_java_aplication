package br.com.luiz.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaPrincipal {

	// Método para mapear requisiçao e retornar a pagina home
	@GetMapping("/gestao/home")
	public String acessarHome() {
		return "gestao/home";

	}
}
