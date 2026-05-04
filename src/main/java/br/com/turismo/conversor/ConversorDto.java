package br.com.turismo.conversor;

import br.com.turismo.dto.PassagemDTO;
import br.com.turismo.entidade.Passagem;
import org.springframework.stereotype.Component;

@Component
public class ConversorDto {

    public Passagem dtoParaEntidade(PassagemDTO passagemDTO){
        var passagem = new Passagem();
        passagem.setId(passagemDTO.id());
        passagem.setNomeCliente(passagemDTO.nomeCliente());
        passagem.setTelefone(passagemDTO.telefone());
        passagem.setOrigem(passagemDTO.origem());
        passagem.setDestino(passagemDTO.destino());
        passagem.setPoltrona(passagemDTO.poltrona());
        passagem.setDataPartida(passagemDTO.dataPartida());
        passagem.setHoraPartida(passagemDTO.horaPartida());
        passagem.setDataVolta(passagemDTO.dataVolta());
        passagem.setValor(passagemDTO.valor());
        return passagem;

    }

    public PassagemDTO entidadeParaDto(Passagem passagem) {

        return new PassagemDTO(
                passagem.getId(),
                passagem.getNomeCliente(),
                passagem.getTelefone(),
                passagem.getOrigem(),
                passagem.getDestino(),
                passagem.getPoltrona(),
                passagem.getDataPartida(),
                passagem.getHoraPartida(),
                passagem.getDataVolta(),
                passagem.getValor());

    }

    public void copiarParaEntidade(PassagemDTO passagemDTO, Passagem passagem) {
        passagem.setNomeCliente(passagemDTO.nomeCliente());
        passagem.setTelefone(passagemDTO.telefone());
        passagem.setOrigem(passagemDTO.origem());
        passagem.setDestino(passagemDTO.destino());
        passagem.setPoltrona(passagemDTO.poltrona());
        passagem.setDataPartida(passagemDTO.dataPartida());
        passagem.setHoraPartida(passagemDTO.horaPartida());
        passagem.setDataVolta(passagemDTO.dataVolta());
        passagem.setValor(passagemDTO.valor());


    }
}
