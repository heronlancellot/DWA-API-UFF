package trabalho.dwa.eventorganizer.domain.edicao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {

    List<Edicao> findByEvento_Id(Long idEvento);
}
