package trabalho.dwa.eventorganizer.application.service.espaco;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;
import trabalho.dwa.eventorganizer.web.dto.builder.EspacoDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ServicoRecuperarEspaco {

    private final EspacoRepository espacoRepository;
    private final EspacoDTOBuilder espacoDTOBuilder;

    public List<EspacoDTO> recuperarListaEspacos() {
        return espacoRepository.findAll().stream().map(espacoDTOBuilder::build)
                .collect(Collectors.toList());
    }
}
