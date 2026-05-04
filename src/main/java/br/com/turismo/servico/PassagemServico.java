package br.com.turismo.servico;


import br.com.turismo.conversor.ConversorDto;
import br.com.turismo.dto.PassagemDTO;
import br.com.turismo.entidade.Passagem;
import br.com.turismo.excessoes.PassagemNaoEncontrada;
import br.com.turismo.repositorio.PassagemRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassagemServico {

    private final PassagemRepositorio passagemRepositorio;
    private final ConversorDto conversorDto;

    @Transactional
    public PassagemDTO salvarPassagem(PassagemDTO passagemDTO){
        var passagem = conversorDto.dtoParaEntidade(passagemDTO);
        var novaPassagem = passagemRepositorio.save(passagem);
        return conversorDto.entidadeParaDto(novaPassagem);
    }

    public List<PassagemDTO>listarPassagens(){
        return passagemRepositorio.findAll()
                .stream().map(conversorDto::entidadeParaDto).toList();
    }

    public Passagem buscarOuLancarExcessao(Long id){
        return passagemRepositorio.findById(id).orElseThrow(
                ()->new PassagemNaoEncontrada("Passagem não encontrada com o id: " + id));
    }

    public PassagemDTO buscarPassagemPorId(Long id){
    var passagem =  buscarOuLancarExcessao(id);
        return conversorDto.entidadeParaDto(passagem);
    }

    @Transactional
    public PassagemDTO atualizarPassagem(Long id, PassagemDTO passagemDTO){
        var passagem =  buscarOuLancarExcessao(id);
         conversorDto.copiarParaEntidade(passagemDTO,passagem);
        var atualizar = passagemRepositorio.save(passagem);
        return conversorDto.entidadeParaDto(atualizar);
    }

    @Transactional
    public void excluirPassagem(Long id){
        var passagem =  buscarOuLancarExcessao(id);
        passagemRepositorio.delete(passagem);
    }
}
