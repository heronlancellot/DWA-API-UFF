package trabalho.dwa.eventorganizer.application.service.espaco;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;

@RequiredArgsConstructor
@Component
public class ServicoAtualizarEspaco {

    private final EspacoRepository espacoRepository;

    public void atualizarEspaco(EspacoDTO espacoDTO) {
        var espaco = espacoRepository.findByNome(espacoDTO.getNome())
                .orElseThrow(() -> new RuntimeException("Espaço não encontrado."));

        espaco.setCapacidade(espacoDTO.getCapacidade());
        espaco.setLocalizacao(espacoDTO.getLocalizacao());

        espacoRepository.save(espaco);
    }
}
