package trabalho.dwa.eventorganizer.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;
import trabalho.dwa.eventorganizer.domain.evento.Evento;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EdicaoDTO {

    private Long id;

    private Integer numero;
    private Integer ano;
    private String cidade;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String organizador;

    public Edicao toEntity() {
        var edicao = new Edicao();
        edicao.setAno(getAno());
        edicao.setCidade(getCidade());
        edicao.setNumero(getNumero());
        edicao.setDataFinal(getDataFinal());
        edicao.setDataInicial(getDataInicial());

        return edicao;
    }
}
