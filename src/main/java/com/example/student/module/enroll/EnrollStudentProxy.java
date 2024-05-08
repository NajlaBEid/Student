package com.example.student.module.enroll;

import com.example.student.module.rabbitmq.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollStudentProxy {


    private final EnrollService service;
    private final EnrollRepository repository;
    private final RabbitMQProducer producer;

    public void createEnrollment(Long studentId, Long courseId) {

        service.create(studentId, courseId);

    }

    public void deleteEnrollment(Long studentId, Long courseId) {
        service.delete(studentId, courseId);
    }

    public EnrollDto findEnrollment(Long studentId, Long courseId) {
       Enroll enroll =  repository.findEnroll(studentId, courseId);
       EnrollDto enrollDto = new EnrollDto();
       enrollDto.setStudentId(enroll.getStudentId());
       enrollDto.setCourseId(enroll.getCourseId());
       producer.sendMessage(enrollDto);
      return enrollDto;

    }
}