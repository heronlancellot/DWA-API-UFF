package trabalho.dwa.eventorganizer.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.dwa.eventorganizer.application.service.espaco.ServicoAtualizarEspaco;
import trabalho.dwa.eventorganizer.application.service.espaco.ServicoManterEspaco;
import trabalho.dwa.eventorganizer.application.service.espaco.ServicoRecuperarEspaco;
import trabalho.dwa.eventorganizer.application.service.espaco.ServicoRemocaoEspaco;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "espacos")
public class EspacoController {

    private final ServicoManterEspaco servicoManterEspaco;
    private final ServicoRecuperarEspaco servicoRecuperarEspaco;
    private final ServicoAtualizarEspaco servicoAtualizarEspaco;
    private final ServicoRemocaoEspaco servicoRemocaoEspaco;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirEspaco(@RequestBody EspacoDTO espacoDTO) {
        servicoManterEspaco.cadastrarEspaco(espacoDTO);
        return ResponseEntity.ok("Espaço cadastrado com sucesso.");
    }

    @GetMapping
    public List<EspacoDTO> recuperarEspacos(){
        return servicoRecuperarEspaco.recuperarListaEspacos();
    }

    @PutMapping( path = "/{idEvento}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarEspaco(@PathVariable("idEvento") Long idEvento, @RequestBody EspacoDTO espacoDTO) {
        servicoAtualizarEspaco.atualizarEspaco(espacoDTO);
        return ResponseEntity.ok("Espaço alterado com sucesso.");
    }

    @DeleteMapping(path = "/{idEspaco}")
    public ResponseEntity<String> removerEspaco(@PathVariable("idEspaco") Long idEspaco) {
        servicoRemocaoEspaco.removerEspaco(idEspaco);
        return ResponseEntity.ok("Espaco removido com sucesso.");
    }
}
