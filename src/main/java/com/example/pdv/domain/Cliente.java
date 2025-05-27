package com.example.pdv.domain;

import com.example.pdv.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name =  "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

