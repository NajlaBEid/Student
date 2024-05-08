package com.example.student.module.department.major.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseAdmissionProxy {

    private final CourseRepository courseRepository;

    public Course findCourse(Long courseId){
        return courseRepository.findCourseById(courseId);
    }
}
