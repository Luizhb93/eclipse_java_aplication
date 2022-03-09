package br.com.luiz.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import br.com.luiz.modelo.Produtos;
import br.com.luiz.repositorio.ProdutoRepositorio;

@Controller
public class ProdutosControle {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	// Método vai retornar um objeto tipo ModelAndView
	// Metodo recebe Como parametro Classe Produtos e passa para visao (Html)
	@GetMapping("gestao/produtos/cadastro")
	public ModelAndView cadastrar(Produtos produto) {
		ModelAndView mv = new ModelAndView("gestao/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("gestao/produtos/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("gestao/produtos/lista");
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
	}

	@GetMapping("/gestao/produtos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Produtos> produto = produtoRepositorio.findById(id);
		return cadastrar(produto.get());
	}

	@GetMapping("/gestao/produtos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Produtos> produto = produtoRepositorio.findById(id);
		produtoRepositorio.delete(produto.get());
		return listar();
	}

	@PostMapping("/gestao/produtos/salvar")
	public ModelAndView salvar(@Validated Produtos produto, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(produto);
		}

		produtoRepositorio.saveAndFlush(produto);
		return cadastrar(new Produtos());

	}
}
