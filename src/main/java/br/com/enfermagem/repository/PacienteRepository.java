package br.com.enfermagem.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.enfermagem.model.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long> {

}
