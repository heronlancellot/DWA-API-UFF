package trabalho.dwa.eventorganizer.application.service.espaco;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trabalho.dwa.eventorganizer.domain.espaco.EspacoRepository;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;
import trabalho.dwa.eventorganizer.web.dto.EspacoDTO;

@Service
@RequiredArgsConstructor
public class ServicoManterEspaco {

    private final EspacoRepository espacoRepository;

    public void cadastrarEspaco(EspacoDTO espacoDTO) {
        if(espacoRepository.findByNome(espacoDTO.getNome()).isPresent()){
            throw new RuntimeException("Espaco já cadastrado.");
        }
        var espaco = espacoDTO.toEntity();

        espacoRepository.save(espaco);
    }

}
