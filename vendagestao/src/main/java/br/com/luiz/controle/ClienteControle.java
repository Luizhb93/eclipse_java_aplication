package br.com.luiz.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.luiz.modelo.Cliente;
import br.com.luiz.repositorio.ClienteRepositorio;

@Controller
public class ClienteControle {

	@Autowired
	private ClienteRepositorio clienterepositorio;

	// Método vai retornar um objeto tipo ModelAndView
	// Metodo recebe Como parametro Cliente e passa para visao (Html)
	@GetMapping("gestao/cliente/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("gestao/cliente/cadcliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@GetMapping("gestao/cliente/listar")
	public String listar() {
		return "gestao/cliente/lista";
	}

	// Método para salvar no Banco as informaçoes e validar(@Validated)
	@PostMapping("gestao/cliente/salvar")
	public ModelAndView salvar(@Validated Cliente cliente, BindingResult result) {

		if (result.hasErrors()) {
			return cadastrar(cliente);
		}

		// cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		clienterepositorio.saveAndFlush(cliente);
		return cadastrar(new Cliente());
	}

}
