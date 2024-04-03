package com.example.student.module.studnet;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudnetService service;

    @PostMapping()
    public StudentDto postMapping(@RequestBody final StudentModel student) {

        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentDto getMapping(@PathVariable final Long id) {
        return service.getByIdWithMajor(id);
    }

    @GetMapping("/n/{id}")
    public StudentDto getMap(@PathVariable final Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public StudentDto putMapping(@RequestBody final StudentModel studentModel, @PathVariable final Long id) {
        return service.updateStudent(studentModel, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable final Long id) {
        return service.deleteId(id);
    }

    @GetMapping()
    public Page<StudentDto> getMapping(final Pageable pageable) {
        return this.service.getPage(pageable);
    }

    @GetMapping("courses/{id}")
    public List<String> getStudentSchedule(@PathVariable final Long id) {
        return service.getStudentCourses(id);
    }

    @PostMapping("/{studentId}/{courseId}")
    public String postMappingEnrollInCourse(@PathVariable final Long studentId, @PathVariable Long courseId) {
       return service.enrollInCourse(studentId,courseId);
    }

    @PostMapping("/drop/{studentId}/{courseId}")
    public String postMappingDropCourse(@PathVariable final Long studentId, @PathVariable Long courseId) {
      return service.dropCourse(studentId,courseId);
    }

}


