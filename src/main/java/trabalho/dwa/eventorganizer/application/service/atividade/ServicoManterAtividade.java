package trabalho.dwa.eventorganizer.application.service.atividade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.atividade.AtividadeRepository;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.web.dto.AtividadeDTO;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;

@Service
@RequiredArgsConstructor
public class ServicoManterAtividade {

    private final AtividadeRepository atividadeRepository;
    private final EventoRepository eventoRepository;
    private final EdicaoRepository edicaoRepository;
    private final EspacoRepository espacoRepository;

    public void cadastrarAtividade(Long idEvento, Long idEdicao, AtividadeDTO atividadeDTO) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        var edicao = edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));

        if(atividadeRepository.findByNome(atividadeDTO.getNome()).isPresent()){
            throw new RuntimeException("Atividade já cadastrada.");
        }

        var atividade = atividadeDTO.toEntity();
        atividade.setEdicao(edicao);

        if(atividadeDTO.getEspacoDTO() != null){
            var espaco = espacoRepository.findById(atividadeDTO.getEspacoDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Espaço não encontrado."));

            atividade.setEspaco(espaco);
        }

        atividadeRepository.save(atividade);
    }
}
