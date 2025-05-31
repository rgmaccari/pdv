package com.example.pdv.domain;

import com.example.pdv.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name =  "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 60)
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
}

