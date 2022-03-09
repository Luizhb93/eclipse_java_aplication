package br.com.luiz.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.luiz.modelo.Funcionario;
import br.com.luiz.repositorio.FuncionarioRepositorio;

@Controller
public class FuncionarioControle {

	@Autowired
	private FuncionarioRepositorio repositoriofuncionario;

	// Método vai retornar um objeto tipo ModelAndView
	// Metodo recebe Como parametro Funcionario e passa para visao (Html)
	@GetMapping("/gestao/funcionario/cadastro")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("/gestao/funcionario/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@GetMapping("/gestao/funcionario/lista")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/gestao/funcionario/lista");
		mv.addObject("listaFuncionario", repositoriofuncionario.findAll());
		return mv;
	}

	// Método para salvar no Banco as informaçoes e validar(@Validated)
	@PostMapping("gestao/funcionario/salvar")
	public ModelAndView salvar(@Validated Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		// funcionario.setSenha(new
		// BCryptPasswordEncoder().encode(funcionario.getSenha()));
		repositoriofuncionario.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
	}

}
