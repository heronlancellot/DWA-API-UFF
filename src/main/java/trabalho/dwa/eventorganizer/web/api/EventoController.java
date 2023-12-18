package trabalho.dwa.eventorganizer.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.dwa.eventorganizer.application.service.atividade.ServicoAtualizarAtividade;
import trabalho.dwa.eventorganizer.application.service.atividade.ServicoManterAtividade;
import trabalho.dwa.eventorganizer.application.service.atividade.ServicoRecuperarAtividade;
import trabalho.dwa.eventorganizer.application.service.edicao.ServicoAtualizarEdicao;
import trabalho.dwa.eventorganizer.application.service.edicao.ServicoManterEdicao;
import trabalho.dwa.eventorganizer.application.service.edicao.ServicoRecuperarEdicao;
import trabalho.dwa.eventorganizer.application.service.evento.ServicoManterEvento;
import trabalho.dwa.eventorganizer.application.service.evento.ServicoRecuperarEvento;
import trabalho.dwa.eventorganizer.application.service.evento.ServicoAtualizarEvento;
import trabalho.dwa.eventorganizer.domain.usuario.Usuario;
import trabalho.dwa.eventorganizer.web.dto.AtividadeDTO;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/eventos")
public class EventoController {

    private final ServicoManterEvento servicoManterEvento;
    private final ServicoManterEdicao servicoManterEdicao;
    private final ServicoRecuperarEvento servicoRecuperarEvento;
    private final ServicoRecuperarEdicao servicoRecuperarEdicao;
    private final ServicoAtualizarEvento servicoAtualizarEvento;
    private final ServicoAtualizarEdicao servicoAtualizarEdicao;
    private final ServicoAtualizarAtividade servicoAtualizarAtividade;
    private final ServicoManterAtividade servicoManterAtividade;
    private final ServicoRecuperarAtividade servicoRecuperarAtividade;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirEvento(@RequestBody EventoDTO eventoDTO) {
        servicoManterEvento.cadastrarEvento(eventoDTO);
        return ResponseEntity.ok("Evento cadastrado com sucesso.");
    }

    @GetMapping
    public List<EventoDTO> recuperarEventos(){
        return servicoRecuperarEvento.recuperarListaEventos();
    }

    @PutMapping( path = "/{idEvento}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarEvento(@PathVariable("idEvento") Long idEvento, @RequestBody EventoDTO eventoDTO) {
        servicoAtualizarEvento.atualizarEvento(idEvento, eventoDTO);
        return ResponseEntity.ok("Evento alterado com sucesso.");
    }

    @GetMapping(path ="/{idEvento}/edicoes")
    public List<EdicaoDTO> recuperarEdicoes(@PathVariable("idEvento") Long idEvento) {
        return servicoRecuperarEdicao.recuperarListaEdicoes(idEvento);
    }

    @PostMapping(path ="/{idEvento}/edicoes" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirEdicao(@PathVariable("idEvento") Long idEvento, @RequestBody EdicaoDTO edicaoDTO) {
        servicoManterEdicao.cadastrarEdicao(idEvento, edicaoDTO);
        return ResponseEntity.ok("Edição cadastrada com sucesso.");
    }

    @PutMapping(path ="/{idEvento}/edicoes" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarEdicao(@PathVariable("idEvento") Long idEvento, @RequestBody EdicaoDTO edicaoDTO) {
        servicoAtualizarEdicao.atualizarEdicao(idEvento, edicaoDTO);
        return ResponseEntity.ok("Edição alterada com sucesso.");
    }

    @PostMapping(path ="/{idEvento}/edicoes/{idEdicao}/usuario/{idUsuario}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> vincularOrganizadorEdicao(@PathVariable("idEvento") Long idEvento,
                                                            @PathVariable("idEdicao") Long idEdicao,
                                                            @PathVariable("idUsuario") Long idUsuario) {

        servicoManterEdicao.vincularOrganizador(idEvento, idEdicao, idUsuario);
        return ResponseEntity.ok("Organizador vinculado com sucesso.");
    }


    @GetMapping(path ="/{idEvento}/edicoes/{idEdicao}/atividades")
    public List<AtividadeDTO> recuperarAtividades(@PathVariable("idEvento") Long idEvento,
                                               @PathVariable("idEdicao") Long idEdicao) {
        return servicoRecuperarAtividade.recuperarListaAtividades(idEvento, idEdicao);
    }

    @PostMapping(path ="/{idEvento}/edicoes/{idEdicao}/atividades" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirAtividade(@PathVariable("idEvento") Long idEvento,
                                                   @PathVariable("idEdicao") Long idEdicao,
                                                   @RequestBody AtividadeDTO atividadeDTO) {
        servicoManterAtividade.cadastrarAtividade(idEvento, idEdicao, atividadeDTO);
        return ResponseEntity.ok("Atividade cadastrada com sucesso.");
    }

    @PutMapping(path ="/{idEvento}/edicoes/{idEdicao}/atividades/{idAtividade}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> alterarAtividade(@PathVariable("idEvento") Long idEvento,
                                                   @PathVariable("idEdicao") Long idEdicao,
                                                   @PathVariable("idAtividade") Long idAtividade,
                                                   @RequestBody AtividadeDTO atividadeDTO) {
        servicoAtualizarAtividade.alterarAtividade(idEvento, idEdicao, idAtividade, atividadeDTO);
        return ResponseEntity.ok("Atividade alterada com sucesso.");
    }

}
