package com.example.pdv.dto;

import jakarta.validation.constraints.*;
import lombok.*;

public class ClienteDTO {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 60)
    private String nome;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 11)
    //Anotação Pattern aceita validações regex - expressões regulares para validação de strings. Essa expressão valida se a string contem apenas números.
    //Além disso, personalizamos a mensagem, pois se não, ela não fica clara para o usuário.
    @Pattern(regexp = "^\\d+$", message = "Deve conter apenas números.")
    private String telefone;

    @Email
    @NotBlank
    @Size(max = 255)
    private String email;

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
