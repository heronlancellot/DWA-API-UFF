package trabalho.dwa.eventorganizer.application.service.evento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;

@Service
@RequiredArgsConstructor
public class ServicoRemocaoEvento {

    private final EventoRepository eventoRepository;

    public void removerEvento(Long idEvento) {
        var evento = eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));
        eventoRepository.delete(evento);
    }
}
