package trabalho.dwa.eventorganizer.web.dto.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.usuario.Usuario;
import trabalho.dwa.eventorganizer.web.dto.UsuarioDTO;

@RequiredArgsConstructor
@Component
public class UsuarioDTOBuilder {

    public UsuarioDTO build(Usuario usuario){
        return UsuarioDTO.builder().id(usuario.getId()).email(usuario.getEmail()).login(usuario.getLogin())
                .nome(usuario.getNome()).senha(usuario.getSenha()).afiliacao(usuario.getAfiliacao()).build();
    }
}
