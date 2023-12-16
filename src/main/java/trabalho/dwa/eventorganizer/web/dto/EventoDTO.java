package trabalho.dwa.eventorganizer.web.dto;

import jakarta.persistence.Column;
import lombok.*;
import trabalho.dwa.eventorganizer.domain.evento.Evento;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventoDTO {

    private Long id;
    private String nome;
    private String acronimo;
    private String descricao;
    private String caminho;
    private List<EdicaoDTO> edicoes;

    public Evento toEntity() {
        var evento = new Evento();
        evento.setAcronimo(getAcronimo());
        evento.setDescricao(getDescricao());
        evento.setNome(getNome());
        evento.setCaminho(getCaminho());

        return evento;
    }
}
