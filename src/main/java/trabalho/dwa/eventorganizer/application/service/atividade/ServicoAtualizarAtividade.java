package trabalho.dwa.eventorganizer.application.service.atividade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.atividade.Atividade;
import trabalho.dwa.eventorganizer.domain.atividade.AtividadeRepository;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.AtividadeDTO;

@RequiredArgsConstructor
@Component
public class ServicoAtualizarAtividade {

    private final AtividadeRepository atividadeRepository;
    private final EventoRepository eventoRepository;
    private final EdicaoRepository edicaoRepository;
    private final EspacoRepository espacoRepository;

    public void alterarAtividade(Long idEvento, Long idEdicao, Long idAtividade, AtividadeDTO atividadeDTO) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));
        var edicao = edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));

        var atividade = atividadeRepository.findById(idAtividade).orElseThrow(() -> new RuntimeException("Atividade não encontrada."));

        atividade.setDataHoraInicial(atividadeDTO.getDataHoraInicial());
        atividade.setDataHoraFinal(atividadeDTO.getDataHoraFinal());
        atividade.setTipo(atividadeDTO.getTipo());
        atividade.setDescricao(atividade.getDescricao());

        if (atividadeDTO.getEspacoDTO() != null && isIdEspacoDiferenteAtual(atividadeDTO, atividade)) {
            var espaco = espacoRepository.findById(atividadeDTO.getEspacoDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Espaço não encontrado."));

            atividade.setEspaco(espaco);
        }

        atividadeRepository.save(atividade);
    }

    private boolean isIdEspacoDiferenteAtual(AtividadeDTO atividadeDTO, Atividade atividade) {
        return atividadeDTO.getEspacoDTO().getId().compareTo(atividade.getEspaco().getId()) != 0;
    }
}
