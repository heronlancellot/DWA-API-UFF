package trabalho.dwa.eventorganizer.application.service.evento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

@RequiredArgsConstructor
@Component
public class ServicoAtualizarEvento {

    private final EventoRepository eventoRepository;

    public void atualizarEvento(Long idEvento, EventoDTO eventoDTO) {
        var evento = eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        evento.setCaminho(eventoDTO.getCaminho());
        evento.setAcronimo(eventoDTO.getAcronimo());
        evento.setDescricao(eventoDTO.getDescricao());

        eventoRepository.save(evento);
    }

}
