package br.com.turismo.excessoes;

import javax.management.RuntimeErrorException;

public class PassagemNaoEncontrada extends RuntimeException {
    public PassagemNaoEncontrada(String mensagem) {
        super(mensagem);
    }
}
