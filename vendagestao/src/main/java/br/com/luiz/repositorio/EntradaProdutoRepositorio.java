package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.EntradaProduto;

public interface EntradaProdutoRepositorio extends JpaRepository<EntradaProduto, Long> {

}
