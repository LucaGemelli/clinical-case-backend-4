package br.com.enfermagem.repository;

import br.com.enfermagem.model.Comentario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long> {
}
