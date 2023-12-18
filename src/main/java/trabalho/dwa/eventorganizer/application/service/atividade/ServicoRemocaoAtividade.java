package trabalho.dwa.eventorganizer.application.service.atividade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.atividade.AtividadeRepository;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;

@Service
@RequiredArgsConstructor
public class ServicoRemocaoAtividade {

    private final EdicaoRepository edicaoRepository;
    private final EventoRepository eventoRepository;
    private final AtividadeRepository atividadeRepository;

    public void removerAtividade(Long idEvento, Long idEdicao, Long idAtividade) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));

        var atividade = atividadeRepository.findById(idAtividade).orElseThrow(() -> new RuntimeException("Edição não encontrada."));
        atividadeRepository.delete(atividade);
    }
}
