package br.com.enfermagem.repository;

import br.com.enfermagem.model.Evolucao;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EvolucaoRepository extends PagingAndSortingRepository<Evolucao, Long> {
}
