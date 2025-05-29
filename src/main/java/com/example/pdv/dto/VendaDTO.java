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

    @NotNull
    private Integer clienteId;

    public VendaDTO() {
    }

    public VendaDTO(String observacao, Date data, BigDecimal total, List<ItemVendaDTO> itensVenda, Integer clienteId) {
        this.observacao = observacao;
        this.data = data;
        this.total = total;
        this.itensVenda = itensVenda;
        this.clienteId = clienteId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemVendaDTO> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVendaDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
