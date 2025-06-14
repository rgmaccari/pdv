package com.example.pdv.domain;

import com.example.pdv.dto.InsertItemVendaDTO;
import com.example.pdv.dto.UpdateItemVendaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name =  "itemvenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVenda {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valorUnitario;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    @JsonIgnore
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemVenda(InsertItemVendaDTO dto, Venda venda, Produto produto) {
        this.quantidade = dto.getQuantidade();
        this.valorUnitario = dto.getValorUnitario();
        this.valorTotal = dto.getValorTotal();
        this.venda = venda;
        this.produto = produto;
    }

    public ItemVenda(UpdateItemVendaDto dto, Venda venda, Produto produto) {
        this.id = dto.getId();
        this.quantidade = dto.getQuantidade();
        this.valorUnitario = dto.getValorUnitario();
        this.valorTotal = dto.getValorTotal();
        this.venda = venda;
        this.produto = produto;
    }
}


