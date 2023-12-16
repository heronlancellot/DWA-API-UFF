package trabalho.dwa.eventorganizer.application.service.edicao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;
import trabalho.dwa.eventorganizer.web.dto.builder.EdicaoDTOBuilder;
import trabalho.dwa.eventorganizer.web.dto.builder.EventoDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ServicoRecuperarEdicao {

    private final EdicaoRepository edicaoRepository;
    private final EdicaoDTOBuilder edicaoDTOBuilder;

    public List<EdicaoDTO> recuperarListaEdicoes(Long idEvento) {
        return edicaoRepository.findByEvento_Id(idEvento).stream().map(edicaoDTOBuilder::build)
                .collect(Collectors.toList());
    }
}
