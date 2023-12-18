package trabalho.dwa.eventorganizer.web.dto.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.espaco.Espaco;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;

@Component
public class EspacoDTOBuilder {
    public EspacoDTO build(Espaco espaco){
        return EspacoDTO.builder().id(espaco.getId()).nome(espaco.getNome())
                .localizacao(espaco.getLocalizacao()).capacidade(espaco.getCapacidade())
                .build();

    }

}
