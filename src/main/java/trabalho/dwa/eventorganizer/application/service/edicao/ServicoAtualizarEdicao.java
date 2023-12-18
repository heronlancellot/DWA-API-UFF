package trabalho.dwa.eventorganizer.application.service.edicao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;

@RequiredArgsConstructor
@Component
public class ServicoAtualizarEdicao {

    private final EdicaoRepository edicaoRepository;
    private final EventoRepository eventoRepository;

    public void atualizarEdicao(Long idEvento, EdicaoDTO edicaoDTO) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Id evento não cadastrado."));

        var edicao = edicaoRepository.findById(edicaoDTO.getId()).orElseThrow(() -> new RuntimeException("Edicao não encontrado."));

        if(edicao.getNumero().compareTo(edicaoDTO.getNumero()) != 0) throw new RuntimeException("Número de uma edição vinculada a um evento," +
                " não pode ser alterado");

        edicao.setCidade(edicaoDTO.getCidade());
        edicao.setDataInicial(edicaoDTO.getDataInicial());
        edicao.setDataFinal(edicaoDTO.getDataFinal());
        edicao.setAno(edicaoDTO.getAno());
        edicao.setChamadaTrabalho(edicaoDTO.getChamadaTrabalho());
        edicao.setPrazoSubmissao(edicaoDTO.getPrazoSubmissao());
        edicao.setPrecoLote(edicaoDTO.getPrecoLote());
        edicao.setLinkInscricao(edicaoDTO.getLinkInscricao());

        edicaoRepository.save(edicao);
    }
}
