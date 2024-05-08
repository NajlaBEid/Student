package com.example.student.module.studnet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAdmissionProxy {
    private final StudentRepository repository;

    public Student findStudent(Long id){
       return repository.findStudentById(id);

    }
}