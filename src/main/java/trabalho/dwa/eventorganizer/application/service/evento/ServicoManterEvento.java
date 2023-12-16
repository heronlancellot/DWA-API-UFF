package trabalho.dwa.eventorganizer.application.service.evento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

@RequiredArgsConstructor
@Service
public class ServicoManterEvento {

    private final EventoRepository eventoRepository;

    public void cadastrarEvento(EventoDTO eventoDTO) {
        if (eventoRepository.findByNome(eventoDTO.getNome()).isPresent()) {
         throw new RuntimeException("Evento já cadastrado.");
        }

        eventoRepository.save(eventoDTO.toEntity());
    }
}
