package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Permissao;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Long>{

}
