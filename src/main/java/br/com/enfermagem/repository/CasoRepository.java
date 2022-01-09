package br.com.enfermagem.repository;

import br.com.enfermagem.model.Caso;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CasoRepository extends PagingAndSortingRepository<Caso, Long> {
}
