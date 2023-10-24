package com.example.alunos.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alunos.dtos.StudentRequest;
import com.example.alunos.dtos.StudentResponse;
import com.example.alunos.entities.Student;
import com.example.alunos.mappers.StudentMapper;
import com.example.alunos.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

     public List<Student> getStudents(){
        return this.repository.findAll();
     }
  public Student getStudent(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Student not found"));
   }

   public void deleteStudentById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Student not found");

      }
   }
    public StudentResponse save(StudentRequest student) {
    var entity =  this.repository.save(StudentMapper.toEntity(student));
    return StudentMapper.toDTO(entity);
   }

   public void update(long id, StudentRequest student) {
      try {
         var updateStudent = this.repository.getReferenceById(id);
         updateStudent.setName(student.name());
         updateStudent.setEmail(student.email());
         updateStudent.setPhone(student.phone());
         updateStudent.setAge(student.age());

         this.repository.save(updateStudent);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Student not found");
      }

   }

}