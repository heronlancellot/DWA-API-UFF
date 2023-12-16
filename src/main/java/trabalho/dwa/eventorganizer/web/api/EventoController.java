package trabalho.dwa.eventorganizer.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.dwa.eventorganizer.application.evento.ServicoManterEvento;
import trabalho.dwa.eventorganizer.application.evento.ServicoRecuperarEvento;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/eventos")
public class EventoController {

    private final ServicoManterEvento servicoManterEvento;

    private final ServicoRecuperarEvento servicoRecuperarEvento;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirEvento(@RequestBody EventoDTO eventoDTO) {
        servicoManterEvento.cadastrarEvento(eventoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<EventoDTO> recuperarEventos(){
        return servicoRecuperarEvento.recuperarListaEventos();
    }

}
