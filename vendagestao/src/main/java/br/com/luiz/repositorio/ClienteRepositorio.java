package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
