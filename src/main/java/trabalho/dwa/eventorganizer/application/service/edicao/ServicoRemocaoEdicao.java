package trabalho.dwa.eventorganizer.application.service.edicao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;

@Service
@RequiredArgsConstructor
public class ServicoRemocaoEdicao {

    private final EdicaoRepository edicaoRepository;
    private final EventoRepository eventoRepository;

    public void removerEdicao(Long idEvento, Long idEdicao) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        var edicao = edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));
        edicaoRepository.delete(edicao);
    }
}
