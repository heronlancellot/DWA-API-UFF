package trabalho.dwa.eventorganizer.web.dto.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.evento.Evento;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventoDTOBuilder {

    private final EdicaoDTOBuilder edicaoDTOBuilder;

    public EventoDTO build(Evento evento){
        return EventoDTO.builder().id(evento.getId()).nome(evento.getNome())
                .acronimo(evento.getAcronimo()).descricao(evento.getDescricao()).caminho(evento.getCaminho())
                .edicoes(evento.getEdicoes().stream().map(edicaoDTOBuilder::build).collect(Collectors.toList()))
                .build();
    }
}
