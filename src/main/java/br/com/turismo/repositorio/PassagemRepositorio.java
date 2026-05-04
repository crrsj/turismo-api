package br.com.turismo.repositorio;

import br.com.turismo.entidade.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepositorio extends JpaRepository<Passagem,Long> {
}
