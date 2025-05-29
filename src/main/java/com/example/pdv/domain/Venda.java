package com.example.pdv.domain;

import com.example.pdv.dto.VendaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name =  "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    private String observacao;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itensVenda;

    public Venda(VendaDTO dto){
        this.observacao = dto.getObservacao();
        this.total = dto.getTotal();
        this.data = dto.getData();
    }

    public Venda(Integer id, VendaDTO dto){
        this.id = id;
        this.observacao = dto.getObservacao();
        this.total = dto.getTotal();
        this.data = dto.getData();
    }

    public Venda() {
    }

    public Venda(Integer id, String observacao, Date data, BigDecimal total, Cliente cliente, List<ItemVenda> itensVenda) {
        this.id = id;
        this.observacao = observacao;
        this.data = data;
        this.total = total;
        this.cliente = cliente;
        this.itensVenda = itensVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
