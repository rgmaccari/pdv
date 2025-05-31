package com.example.pdv.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class UpdateVendaDTO {
    @Size(max = 255)
    private String observacao;

    @PositiveOrZero
    @NotNull
    private BigDecimal total;

    @NotEmpty
    //@Valid aqui para que seja validado os itens da lista. Se não o validation bean ignora.
    private List<@Valid UpdateItemVendaDto> itensVenda;

    @NotNull
    private Integer clienteId;
}
