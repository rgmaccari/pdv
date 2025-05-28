package com.example.pdv.domain;

import com.example.pdv.dto.ItemVendaDTO;
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
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemVenda(ItemVendaDTO dto){
        this.quantidade = dto.getQuantidade();
        this.valorUnitario = dto.getValorUnitario();
        this.valorTotal = dto.getValorTotal();
        this.venda = dto.getVenda();
        this.produto = dto.getProduto();
    }

    public ItemVenda(Integer id, ItemVendaDTO dto){
        this.id = id;
        this.quantidade = dto.getQuantidade();
        this.valorUnitario = dto.getValorUnitario();
        this.valorTotal = dto.getValorTotal();
        this.venda = dto.getVenda();
        this.produto = dto.getProduto();
    }
}


