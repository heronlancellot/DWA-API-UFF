package trabalho.dwa.eventorganizer.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.usuario.UsuarioRepository;
import trabalho.dwa.eventorganizer.web.dto.UsuarioDTO;

@RequiredArgsConstructor
@Service
public class ServicoManterUsuario {

    private final UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if(usuarioRepository.findByLogin(usuarioDTO.getLogin()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado.");
        }

        usuarioRepository.save(usuarioDTO.toEntity());
    }
}
