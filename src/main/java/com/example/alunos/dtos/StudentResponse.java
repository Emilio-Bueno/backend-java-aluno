package com.example.alunos.dtos;

public record StudentResponse(
    Long id,
    String name,
    String email,
    String phone,
    String age
) {
}