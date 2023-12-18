package trabalho.dwa.eventorganizer.web.dto.builder;

import org.springframework.stereotype.Component;
import trabalho.dwa.eventorganizer.domain.edicao.Edicao;
import trabalho.dwa.eventorganizer.web.dto.EdicaoDTO;

@Component
public class EdicaoDTOBuilder {

    public EdicaoDTO build(Edicao edicao){
        return EdicaoDTO.builder().id(edicao.getId()).ano(edicao.getAno()).cidade(edicao.getCidade())
                .dataInicial(edicao.getDataInicial()).dataFinal(edicao.getDataFinal()).numero(edicao.getNumero())
                .organizador(edicao.getOrganizador() != null ? edicao.getOrganizador().getNome() : null)
                .chamadaTrabalho(edicao.getChamadaTrabalho()).precoLote(edicao.getPrecoLote())
                .prazoSubmissao(edicao.getPrazoSubmissao()).linkInscricao(edicao.getLinkInscricao())
                .build();
    }

}
