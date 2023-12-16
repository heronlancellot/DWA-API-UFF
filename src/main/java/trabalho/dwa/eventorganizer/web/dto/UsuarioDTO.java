package trabalho.dwa.eventorganizer.web.dto;

import lombok.*;
import trabalho.dwa.eventorganizer.domain.usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO {
    private Long id;
    private String login;
    private String email;
    private String nome;
    private String afiliacao;
    private String senha;

    public Usuario toEntity() {
        var usuario = new Usuario();
        usuario.setAfiliacao(getAfiliacao());
        usuario.setNome(getNome());
        usuario.setEmail(getEmail());
        usuario.setLogin(getLogin());
        usuario.setSenha(getSenha());
        return usuario;
    }
}
