package com.example.pdv.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

}


/*
CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    observacao VARCHAR(100),
    data TIMESTAMP NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    cliente_id INTEGER NOT NULL, -- Coluna para a chave estrangeira
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
* */
