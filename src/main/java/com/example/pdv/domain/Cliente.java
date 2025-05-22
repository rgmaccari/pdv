package com.example.pdv.domain;


public class Cliente {
    private Integer id;
    private String nome;
    private Long telefone;
    private String email;
}

/**

 CREATE TABLE cliente(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone BIGINT NOT NULL,
    email VARCHAR(100)
 );
 * */
