package com.example.pdv.dto;

import com.example.pdv.domain.Produto;
import com.example.pdv.domain.Venda;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemVendaDTO {
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
    private Venda venda;

    @NotNull
    private Produto produto;
}
