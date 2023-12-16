package trabalho.dwa.eventorganizer.application.evento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

@RequiredArgsConstructor
@Component
public class ServicoManterEvento {

    private final EventoRepository eventoRepository;

    public void cadastrarEvento(EventoDTO eventoDTO) {
        if (eventoRepository.findByNome(eventoDTO.getNome()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado.");
        }

        eventoRepository.save(eventoDTO.toEntity());
    }
}
