package trabalho.dwa.eventorganizer.application.service.espaco;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.domain.evento.EventoRepository;

@Service
@RequiredArgsConstructor
public class ServicoRemocaoEspaco {

    private final EspacoRepository espacoRepository;

    public void removerEspaco(Long idEspaco) {
        var espaco = espacoRepository.findById(idEspaco).orElseThrow(() -> new RuntimeException("Espaço não encontrado."));
        espacoRepository.delete(espaco);
    }
}
