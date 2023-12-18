package trabalho.dwa.eventorganizer.web.dto;

import lombok.*;
import trabalho.dwa.eventorganizer.domain.atividade.Atividade;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AtividadeDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private LocalDateTime dataHoraInicial;
    private  LocalDateTime dataHoraFinal;
    private EspacoDTO espacoDTO;

    public Atividade toEntity() {
        var atividade = new Atividade();
        atividade.setNome(getNome());
        atividade.setDataHoraFinal(getDataHoraFinal());
        atividade.setDataHoraInicial(getDataHoraInicial());
        atividade.setTipo(getTipo());
        atividade.setDescricao(getDescricao());

        return atividade;
    }
}

//(palestra, painel, sessão técnica)