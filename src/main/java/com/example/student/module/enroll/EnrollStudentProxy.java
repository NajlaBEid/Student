package com.example.student.module.enroll;

import com.example.student.module.studnet.Student;
import com.example.student.module.studnet.StudentDto;
import com.example.student.module.studnet.StudentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollStudentProxy {


    private final EnrollService service;
    public void createEnrollment(Long studentId, Long courseId){

      service.create(studentId,courseId);

    }
    public void  deleteEnrollment(Long studentId, Long courseId){
        service.delete(studentId,courseId);
    }





}
