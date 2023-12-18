package trabalho.dwa.eventorganizer.application.service.atividade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.atividade.AtividadeRepository;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.domain.usuario.UsuarioRepository;
import trabalho.dwa.eventorganizer.web.dto.AtividadeDTO;
import trabalho.dwa.eventorganizer.web.dto.UsuarioDTO;
import trabalho.dwa.eventorganizer.web.dto.builder.AtividadeDTOBuilder;
import trabalho.dwa.eventorganizer.web.dto.builder.UsuarioDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServicoRecuperarAtividade {

    private final AtividadeRepository atividadeRepository;
    private final EventoRepository eventoRepository;
    private final EdicaoRepository edicaoRepository;
    private final AtividadeDTOBuilder builder;

    public List<AtividadeDTO> recuperarListaAtividades(Long idEvento, Long idEdicao){
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));

        return atividadeRepository.findAllByEdicao_Id(idEdicao).stream().map(builder::build)
                .collect(Collectors.toList());
    }


}
