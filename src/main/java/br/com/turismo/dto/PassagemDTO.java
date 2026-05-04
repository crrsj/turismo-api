package br.com.turismo.dto;

import br.com.turismo.enums.Destino;
import br.com.turismo.enums.Origem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record PassagemDTO(
        Long id,
        @NotBlank
        String nomeCliente,
        @NotBlank
        String telefone,
        @NotNull
        Origem origem,
        @NotNull
        Destino destino,
        @NotNull
        int poltrona,
        @NotNull
        LocalDate dataPartida,
        @NotNull
        LocalTime horaPartida,
        @NotNull
        LocalDate dataVolta,
        @NotNull
        @Positive
        Double valor) {
}
