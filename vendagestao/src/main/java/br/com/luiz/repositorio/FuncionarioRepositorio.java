package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
