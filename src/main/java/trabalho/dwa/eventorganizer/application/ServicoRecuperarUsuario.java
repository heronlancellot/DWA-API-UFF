package trabalho.dwa.eventorganizer.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.usuario.UsuarioRepository;
import trabalho.dwa.eventorganizer.web.dto.UsuarioDTO;
import trabalho.dwa.eventorganizer.web.dto.builder.UsuarioDTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServicoRecuperarUsuario {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDTOBuilder usuarioDTOBuilder;

    public List<UsuarioDTO> recuperarListaUsuarios(){
        return usuarioRepository.findAll().stream().map(usuarioDTOBuilder::build)
                .collect(Collectors.toList());
    }

//    public UsuarioDTO recuperarUsuarioPorLogin(String login) {
//        usuarioRepository.findByLogin(login)
//        return usuarioDTOBuilder.build();
//    }
}
