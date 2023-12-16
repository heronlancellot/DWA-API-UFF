package trabalho.dwa.eventorganizer.domain.evento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DWA_EVENTO")
public class Evento {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String nome;

    @Column(name = "ACRONYM", nullable = false)
    private String acronimo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

}
