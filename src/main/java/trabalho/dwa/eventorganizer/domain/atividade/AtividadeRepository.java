package trabalho.dwa.eventorganizer.domain.atividade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    List<Atividade> findAllByEdicao_Id(Long idEdicao);

    Optional<Atividade> findByNome(String nome);
}
