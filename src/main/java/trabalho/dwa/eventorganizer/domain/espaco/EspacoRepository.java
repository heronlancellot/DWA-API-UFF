package trabalho.dwa.eventorganizer.domain.espaco;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.dwa.eventorganizer.domain.evento.Evento;

import java.util.Optional;

public interface EspacoRepository extends JpaRepository<Espaco, Long> {

    Optional<Espaco> findByNome(String nome);

}
