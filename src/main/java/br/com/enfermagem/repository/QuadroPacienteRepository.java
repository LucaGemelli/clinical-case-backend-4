package br.com.enfermagem.repository;

import br.com.enfermagem.model.QuadroPaciente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuadroPacienteRepository extends PagingAndSortingRepository<QuadroPaciente, Long> {
}
