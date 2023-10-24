package com.example.alunos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alunos.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}