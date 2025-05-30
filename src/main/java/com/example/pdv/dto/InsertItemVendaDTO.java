package com.example.pdv.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsertItemVendaDTO {
    @NotNull
    @PositiveOrZero
    private Integer quantidade;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorUnitario;

    @NotNull
    @PositiveOrZero
    private BigDecimal valorTotal;

    @NotNull
    private Integer produtoId;
}
