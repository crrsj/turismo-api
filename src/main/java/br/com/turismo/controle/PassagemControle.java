package br.com.turismo.controle;

import br.com.turismo.dto.PassagemDTO;
import br.com.turismo.servico.PassagemServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passagem")
@RequiredArgsConstructor
public class PassagemControle {

    private final PassagemServico passagemServico;


    @PostMapping
    @Operation(summary = "endpoint responsável pelo registro da passagem.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PassagemDTO>salvarPassagem(@RequestBody PassagemDTO passagemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(passagemServico.salvarPassagem(passagemDTO));
    }

    @GetMapping
    @Operation(summary = "endpoint responsável pela busca de todas as passagens.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<PassagemDTO>>listarPassagens(){
        return ResponseEntity.ok(passagemServico.listarPassagens());
    }

    @GetMapping("/{id}")
    @Operation(summary = "endpoint responsável pela busca da passagem pelo id.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PassagemDTO>buscarPassagemPPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(passagemServico.buscarPassagemPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "endpoint responsável pela atualização da passagem buscando pelo id.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PassagemDTO>atualizarPassagem(@PathVariable Long id,@RequestBody PassagemDTO passagemDTO){
        return ResponseEntity.status(HttpStatus.OK).body(passagemServico.atualizarPassagem(id, passagemDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsável pela exclusão da passagem buscando pelo id.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirPassagem(@PathVariable Long id){
        passagemServico.excluirPassagem(id);
        return ResponseEntity.noContent().build();
    }
}
