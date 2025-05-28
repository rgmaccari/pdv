package com.example.pdv.domain;

import com.example.pdv.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name =  "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    private String email;

    public Cliente(ClienteDTO dto){
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
        this.email = dto.getEmail();
    }

    public Cliente(Integer id, ClienteDTO dto){
        this.id = id;
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
        this.email = dto.getEmail();
    }

    public Cliente(Integer id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

