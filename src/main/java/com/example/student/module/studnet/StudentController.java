package com.example.student.module.studnet;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudnetService service;

    @PostMapping()
    public StudentDto postMapping(@RequestBody final StudentModel student){

    return service.createStudent(student);
    }
    @GetMapping("/{id}")
    public StudentDto getMapping(@PathVariable final Long id){
       return service.getByIdWithMajor(id);
    }


    @PutMapping("/{id}")
    public StudentDto putMapping(@RequestBody final StudentModel studentModel, @PathVariable final Long id){
        return service.updateStudent(studentModel, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable final Long id){
    return service.deleteId(id);
    }

    @GetMapping()
    public Page<StudentDto> getMapping(final Pageable pageable) {
        return this.service.getPage(pageable);
    }

}
