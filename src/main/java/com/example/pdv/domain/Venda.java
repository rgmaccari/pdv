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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
        this.cliente = dto.getCliente();
    }

    public Venda(Integer id, VendaDTO dto){
        this.id = id;
        this.observacao = dto.getObservacao();
        this.total = dto.getTotal();
        this.data = dto.getData();
        this.cliente = dto.getCliente();
    }
}
