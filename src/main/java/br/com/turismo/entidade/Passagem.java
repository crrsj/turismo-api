package br.com.turismo.entidade;

import br.com.turismo.enums.Destino;
import br.com.turismo.enums.Origem;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Origem origem;
    @Enumerated(EnumType.STRING)
    private Destino destino;
    private int poltrona;
    private LocalDate dataPartida;
    private LocalTime horaPartida;
    private LocalDate dataVolta;
    private Double valor;


}

