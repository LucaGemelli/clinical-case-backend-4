package br.com.enfermagem.repository;

import br.com.enfermagem.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
}
