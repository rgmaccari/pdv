package com.example.pdv.domain;

import com.example.pdv.dto.InsertVendaDTO;
import com.example.pdv.dto.UpdateVendaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name =  "venda")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itensVenda;

    public Venda(InsertVendaDTO dto){
        this.observacao = dto.getObservacao();
        this.total = dto.getTotal();
        this.data = dto.getData();
    }

    public Venda(Integer id, InsertVendaDTO dto){
        this.id = id;
        this.observacao = dto.getObservacao();
        this.total = dto.getTotal();
    }

    public Venda(Integer id, UpdateVendaDTO dto){
        this.id = id;
        this.observacao = dto.getObservacao();
    }
}
