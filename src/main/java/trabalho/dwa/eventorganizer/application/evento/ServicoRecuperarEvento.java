package trabalho.dwa.eventorganizer.application.evento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;
import trabalho.dwa.eventorganizer.web.dto.builder.EventoDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicoRecuperarEvento {

    private final EventoRepository eventoRepository;
    private final EventoDTOBuilder builder;

    public List<EventoDTO> recuperarListaEventos() {
        return eventoRepository.findAll().stream().map(builder::build)
                .collect(Collectors.toList());
    }
}
