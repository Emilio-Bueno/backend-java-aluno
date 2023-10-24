package com.example.alunos.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
    @NotBlank(message = "O Nome não pode ser em branco")
    String name,
    @NotBlank(message = "O email não pode ser em branco")
    String email,
    @NotBlank(message = "O telefone não pode ser em branco")
    String phone,
    @NotBlank(message = "A idade não pode ser em branco")
    String age
) {
    
}
