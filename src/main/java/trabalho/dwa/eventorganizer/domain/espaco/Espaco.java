package trabalho.dwa.eventorganizer.domain.espaco;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DWA_ESPACO")
public class Espaco {

    @Id
    @Column(name = "ID_ESPACO")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME_ESPACO", nullable = false)
    private String nome;

    @Column(name = "LOCALIZACAO_ESPACO", nullable = false)
    private String localizacao;

    @Column(name = "CAPACIDADE_ESPACO", nullable = false)
    private Integer capacidade;

    @OneToOne(mappedBy = "espaco")
    private Atividade atividade;

}

