package trabalho.dwa.eventorganizer.domain.atividade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trabalho.dwa.eventorganizer.domain.atividade.Atividade;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;
import trabalho.dwa.eventorganizer.domain.espaco.Espaco;
import trabalho.dwa.eventorganizer.domain.evento.Evento;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DWA_ATIVIDADE")
public class Atividade {

    @Id
    @Column(name = "ID_ATIVIDADE")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME_ATIVIDADE", nullable = false)
    private String nome;

    @Column(name = "TIPO_ATIVIDADE", nullable = false)
    private String tipo;

    @Column(name = "DES_ATIVIDADE")
    private String descricao;

    @Column(name = "DAT_HOR_INICIAL", nullable = false)
    private LocalDateTime dataHoraInicial;

    @Column(name = "DAT_HOR_FINAL", nullable = false)
    private LocalDateTime dataHoraFinal;

    @ManyToOne
    @JoinColumn(name = "ID_EDICAO", nullable = false)
    private Edicao edicao;

    @OneToOne
    @JoinColumn(name = "ID_ESPACO", nullable = false)
    private Espaco espaco;
}
