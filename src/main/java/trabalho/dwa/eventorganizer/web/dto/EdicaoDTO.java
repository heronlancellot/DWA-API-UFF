package trabalho.dwa.eventorganizer.web.dto;

import lombok.*;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;

import java.math.BigDecimal;
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
    private String chamadaTrabalho;
    private LocalDate prazoSubmissao;
    private BigDecimal precoLote;
    private String linkInscricao;


    public Edicao toEntity() {
        var edicao = new Edicao();
        edicao.setAno(getAno());
        edicao.setCidade(getCidade());
        edicao.setNumero(getNumero());
        edicao.setDataFinal(getDataFinal());
        edicao.setDataInicial(getDataInicial());
        edicao.setChamadaTrabalho(getChamadaTrabalho());
        edicao.setPrazoSubmissao(getPrazoSubmissao());
        edicao.setPrecoLote(getPrecoLote());
        edicao.setLinkInscricao(getLinkInscricao());

        return edicao;
    }
}
