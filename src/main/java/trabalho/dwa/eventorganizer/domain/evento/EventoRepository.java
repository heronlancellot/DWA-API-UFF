package trabalho.dwa.eventorganizer.domain.evento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    Optional<Evento> findByNome(String nome);
}
