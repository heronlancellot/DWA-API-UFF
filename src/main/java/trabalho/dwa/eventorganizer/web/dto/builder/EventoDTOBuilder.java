package trabalho.dwa.eventorganizer.web.dto.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.evento.Evento;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

@RequiredArgsConstructor
@Component
public class EventoDTOBuilder {

    public EventoDTO build(Evento evento){
        return EventoDTO.builder().id(evento.getId()).nome(evento.getNome())
                .acronimo(evento.getAcronimo()).descricao(evento.getDescricao()).build();
    }
}
