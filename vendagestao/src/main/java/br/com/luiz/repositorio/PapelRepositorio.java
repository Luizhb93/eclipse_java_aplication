package br.com.luiz.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiz.modelo.Papel;

public interface PapelRepositorio extends JpaRepository<Papel, Long> {

}
