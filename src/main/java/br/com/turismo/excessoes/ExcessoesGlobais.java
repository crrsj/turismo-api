package br.com.turismo.excessoes;

import br.com.turismo.dto.CamposValidos;
import br.com.turismo.dto.MensagemDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcessoesGlobais {

    @ExceptionHandler(PassagemNaoEncontrada.class)
    public ResponseEntity<MensagemDeErro>passagemNaoEncontrada(){
        var mensagem = new MensagemDeErro(HttpStatus.NOT_FOUND,"Passagem não encontrada!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>ValidandoCampos(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(CamposValidos::new).toList());
    }
}
