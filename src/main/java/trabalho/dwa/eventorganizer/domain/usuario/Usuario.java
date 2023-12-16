package trabalho.dwa.eventorganizer.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DWA_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "AFILIACAO")
    private String afiliacao;

    @OneToOne(mappedBy = "organizador")
    private Edicao edicao;

}
