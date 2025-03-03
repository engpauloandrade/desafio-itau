package com.example.demo.domain;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class TransacaoRequest {

    @NotNull(message = "O valor não pode ser nulo.")
    @DecimalMin(value = "0.00", inclusive = true, message = "O valor deve ser maior ou igual a 0.")
    private BigDecimal valor;

    @NotNull(message = "A dataHora não pode ser nula.")
    @PastOrPresent(message = "A dataHora não pode estar no futuro.")
    private OffsetDateTime dataHora;
}
