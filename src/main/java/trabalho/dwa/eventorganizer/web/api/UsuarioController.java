package trabalho.dwa.eventorganizer.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.dwa.eventorganizer.application.service.usuario.ServicoManterUsuario;
import trabalho.dwa.eventorganizer.application.service.usuario.ServicoRecuperarUsuario;
import trabalho.dwa.eventorganizer.web.dto.UsuarioDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private final ServicoRecuperarUsuario servicoRecuperarUsuario;

    private final ServicoManterUsuario servicoManterUsuario;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> incluirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        servicoManterUsuario.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @GetMapping
    public List<UsuarioDTO> recuperarUsuarios(){
        return servicoRecuperarUsuario.recuperarListaUsuarios();
    }

}
