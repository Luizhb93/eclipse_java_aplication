package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Produtos;

public interface ProdutoRepositorio extends JpaRepository<Produtos, Long> {

}
