package com.example.student.module.studnet;

import com.example.student.module.major.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudnetService Service;


    @PostMapping()
    public StudentDto postMapping(@RequestBody final StudentModel student){

    return Service.createStudent(student);
    }
    @GetMapping("/{id}")
    public StudentDto getMapping(@PathVariable final Long id){
       return Service.getById(id);
    }


    @PutMapping("/{id}")
    public StudentDto putMapping(@RequestBody final StudentModel studentModel, @PathVariable final Long id){
        return Service.updateStudent(studentModel, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable final Long id){
    return Service.deleteId(id);
    }



//    @PutMapping("{/id}/major")
//    public StudentDto updateMajor(@RequestBody StudentDto studentDTO, Long id){
//       return Service.updateStudentMajor(studentDTO, id);
//
//    }


}
