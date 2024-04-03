package com.example.student.module.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping()
    public DepartmentDto postMapping(@RequestBody final DepartmentModel model){
        return service.create(model);
    }


    @GetMapping("/{id}")
    public DepartmentDto getMapping(@PathVariable final Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public DepartmentDto putMapping(@RequestBody final DepartmentModel model, @PathVariable final Long id){
        return service.update(model,id);
    }

    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable final Long id){
        return service.delete(id);
    }



}
