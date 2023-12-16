package trabalho.dwa.eventorganizer.web.dto;

import jakarta.persistence.Column;
import lombok.*;
import trabalho.dwa.eventorganizer.domain.evento.Evento;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventoDTO {

    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String nome;

    @Column(name = "ACRONYM", nullable = false)
    private String acronimo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public Evento toEntity() {
        var evento = new Evento();
        evento.setAcronimo(getAcronimo());
        evento.setDescricao(getDescricao());
        evento.setNome(getNome());

        return evento;
    }
}
