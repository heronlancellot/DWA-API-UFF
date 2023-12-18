package trabalho.dwa.eventorganizer.web.dto.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.atividade.Atividade;
import trabalho.dwa.eventorganizer.domain.espaco.Espaco;
import trabalho.dwa.eventorganizer.web.dto.AtividadeDTO;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;

@Component
@RequiredArgsConstructor
public class AtividadeDTOBuilder {

    private final EspacoDTOBuilder espacoDTOBuilder;
    public AtividadeDTO build(Atividade atividade){
        return AtividadeDTO.builder().id(atividade.getId()).nome(atividade.getNome())
                .dataHoraFinal(atividade.getDataHoraFinal()).dataHoraInicial(atividade.getDataHoraInicial())
                .descricao(atividade.getDescricao()).tipo(atividade.getTipo())
                .espacoDTO(espacoDTOBuilder.build(atividade.getEspaco())).build();

    }

}
