package com.example.pdv.domain;

public class Produto {
    private Integer id;
    private String descricao;
    private Double preco;
    private String categoria;
}

/*
CREATE TABLE produto(
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	valor NUMERIC(10, 2) NOT NULL,
	categoria VARCHAR NOT NULL
);
* */
