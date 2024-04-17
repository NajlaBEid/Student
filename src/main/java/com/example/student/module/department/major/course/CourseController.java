package com.example.student.module.department.major.course;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService service;

    @PostMapping
    public CourseDto postMapping(@RequestBody final CourseModel model){
        return service.createCourse(model);
    }

    @GetMapping("/{id}")
    public CourseDto getMapping(@PathVariable final Long id){
        return service.getCourse(id);
    }

    @PutMapping("/{id}")
    public CourseDto putMapping(@RequestBody final CourseModel model, @PathVariable final Long id){
        return service.updateCourse(model, id);
    }
    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable Long id){
        return service.deleteCourse(id);
    }
}
