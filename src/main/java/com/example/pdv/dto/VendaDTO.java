package com.example.pdv.dto;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.ItemVenda;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class VendaDTO {

    private String observacao;

    @NotNull
    private Date data;

    @PositiveOrZero
    @NotNull
    private BigDecimal total;

    @NotEmpty
    private List<ItemVendaDTO> itensVenda;

    private Cliente cliente;
}
