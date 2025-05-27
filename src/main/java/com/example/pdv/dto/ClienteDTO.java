package com.example.pdv.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 60)
    private String nome;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 11)
    private String telefone;

    @Email(message = "Informe um e-mail válido.")
    private String email;
}
