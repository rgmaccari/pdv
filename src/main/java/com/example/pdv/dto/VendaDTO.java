package com.example.pdv.dto;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.ItemVenda;
import jakarta.persistence.ManyToOne;
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
public class VendaDTO {

    @Size(max = 200)
    private String observacao;

    @NotNull
    private Date data;

    @PositiveOrZero
    @NotNull
    private BigDecimal total;

    @NotEmpty
    //@Valid aqui para que seja validado os itens da lista. Se não o validation bean ignora.
    private List<@Valid ItemVendaDTO> itensVenda;

    private Integer clienteId;
}
