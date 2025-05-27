package com.example.pdv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    @NotBlank
    @Size(min = 3, max = 60)
    private String descricao;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotBlank
    @Size(min = 3, max = 10)
    private String categoria;
}
