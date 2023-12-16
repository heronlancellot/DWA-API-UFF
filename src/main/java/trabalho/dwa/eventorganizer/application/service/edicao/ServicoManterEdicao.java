package trabalho.dwa.eventorganizer.application.service.edicao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;
import trabalho.dwa.eventorganizer.domain.edicao.EdicaoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;
import trabalho.dwa.eventorganizer.domain.usuario.UsuarioRepository;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;
import trabalho.dwa.eventorganizer.web.dto.EventoDTO;

@Service
@RequiredArgsConstructor
public class ServicoManterEdicao {

    private final EdicaoRepository edicaoRepository;
    private final EventoRepository eventoRepository;
    private final UsuarioRepository usuarioRepository;

    public void cadastrarEdicao(Long idEvento, EdicaoDTO edicaoDTO) {
        var evento = eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        if(evento.getEdicoes().stream().anyMatch(ed -> ed.getNumero().compareTo(edicaoDTO.getNumero()) == 0)){
            throw new RuntimeException("Edição já cadastrada.");
        }

        var edicao = edicaoDTO.toEntity();
        edicao.setEvento(evento);

        edicaoRepository.save(edicao);
    }

    public void vincularOrganizador(Long idEvento, Long idEdicao, Long idUsuario) {
        eventoRepository.findById(idEvento).orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        var edicao = edicaoRepository.findById(idEdicao).orElseThrow(() -> new RuntimeException("Edição não encontrada."));

        var usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.setEdicao(edicao);
        usuario = usuarioRepository.save(usuario);

        edicao.setOrganizador(usuario);
        edicaoRepository.save(edicao);
    }
}
