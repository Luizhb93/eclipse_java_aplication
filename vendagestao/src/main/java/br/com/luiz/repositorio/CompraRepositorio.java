package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Compra;

public interface CompraRepositorio extends JpaRepository<Compra, Long> {

}
