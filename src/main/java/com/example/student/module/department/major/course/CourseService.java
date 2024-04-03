package com.example.student.module.department.major.course;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/course")


public class CourseService {

    private final CourseRepository repository;

    @Qualifier("courseMapper")
    private final CourseMapper mapper;

    public CourseDto createCourse(CourseModel model){
        Course course = this.mapper.toEntity(model);
        this.repository.save(course);
        CourseDto courseDto= this.mapper.toDto(course);
        return courseDto;
    }

    public CourseDto getCourse(Long id) {
        Course course = repository.findCourseById(id);
        CourseDto courseDto = this.mapper.toDto(course);
        return courseDto;

    }
    public CourseDto updateCourse(CourseModel model, Long id){
        Course course = repository.findCourseById(id);
        course = this.mapper.modelToEntity(model,course);
        this.repository.save(course);
        CourseDto courseDto= this.mapper.toDto(course);
        return courseDto;
    }
    public String deleteCourse(Long id){
        repository.deleteById(id);
        return "Course with ID "+id+" deleted";

    }
    public Page<CourseDto> getPage(final Pageable page){
        return this.mapper.toPage(this.repository.findAll(page));
    }


}
