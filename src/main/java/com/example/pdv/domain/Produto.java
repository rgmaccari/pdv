package com.example.pdv.domain;

import com.example.pdv.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name =  "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String categoria;

    public Produto(ProdutoDTO dto){
        this.descricao = dto.getDescricao();
        this.valor = dto.getValor();
        this.categoria = dto.getCategoria();
    }

    public Produto(Integer id, ProdutoDTO dto){
        this.id = id;
        this.descricao = dto.getDescricao();
        this.valor = dto.getValor();
        this.categoria = dto.getCategoria();
    }

    public Produto(Integer id, String descricao, BigDecimal valor, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

