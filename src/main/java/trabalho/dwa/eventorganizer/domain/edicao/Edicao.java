package trabalho.dwa.eventorganizer.domain.edicao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trabalho.dwa.eventorganizer.domain.atividade.Atividade;
import trabalho.dwa.eventorganizer.domain.evento.Evento;
import trabalho.dwa.eventorganizer.domain.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DWA_EDICAO")
public class Edicao {

    @Id
    @Column(name = "ID_EDICAO")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NUMERO_EDICAO", nullable = false)
    private Integer numero;

    @Column(name = "ANO", nullable = false)
    private Integer ano;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "DAT_INICIAL", nullable = false)
    private LocalDate dataInicial;

    @Column(name = "DAT_FINAL", nullable = false)
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name="ID_EVENTO", nullable=false)
    private Evento evento;

    @OneToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario organizador;

    @Column(name = "TIPO_TRABALHO")
    private String chamadaTrabalho;

    @Column(name = "PRAZO_SUBMISSAO")
    private LocalDate prazoSubmissao;

    @Column(name = "PRECO_LOTE")
    private BigDecimal precoLote;

    @Column(name = "LINK_INSCRICAO")
    private String linkInscricao;

    @OneToMany(mappedBy = "edicao")
    private List<Atividade> atividades;

}

