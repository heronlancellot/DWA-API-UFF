package trabalho.dwa.eventorganizer.web.dto;

import lombok.*;
import trabalho.dwa.eventorganizer.domain.espaco.Espaco;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EspacoDTO {

    private Long id;
    private String nome;
    private String localizacao;
    private Integer capacidade;
    private AtividadeDTO atividadeDTO;

    public Espaco toEntity() {
        var espaco = new Espaco();
        espaco.setCapacidade(getCapacidade());
        espaco.setNome(getNome());
        espaco.setLocalizacao(getLocalizacao());
        espaco.setCapacidade(getCapacidade());

        return espaco;
    }
    
}
