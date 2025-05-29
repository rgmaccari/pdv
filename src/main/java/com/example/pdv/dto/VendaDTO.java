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

    public VendaDTO() {
    }

    public VendaDTO(String observacao, Date data, BigDecimal total, List<ItemVendaDTO> itensVenda, Cliente cliente) {
        this.observacao = observacao;
        this.data = data;
        this.total = total;
        this.itensVenda = itensVenda;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
