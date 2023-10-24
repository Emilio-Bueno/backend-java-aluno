package com.example.alunos.mappers;


import java.util.List;
import java.util.stream.Collectors;

import com.example.alunos.dtos.StudentRequest;
import com.example.alunos.dtos.StudentResponse;
import com.example.alunos.entities.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.name());
        student.setEmail(request.email());
        student.setAge(request.phone());
        student.setPhone(request.phone());
        return student;
    }

    public static StudentResponse toDTO(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getEmail(), student.getPhone(),
                student.getAge());
    }

    public static List<StudentResponse> toDTOList(List<Student> students) {
        return students.stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}