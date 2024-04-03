package com.example.student.module.enroll;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnrollService {


    final private  EnrollRepository repository;


    public void create(Long studentId, Long courseId){

        Enroll enroll = new Enroll();
        enroll.setStudentId(studentId);
        enroll.setCourseId(courseId);
        repository.save(enroll);



    }

    public void delete(Long studentId, Long courseId) {
        Long enrollmentId= repository.findEnrollment(studentId,courseId);
       repository.deleteById(enrollmentId);

    }



}


