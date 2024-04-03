package com.example.student.module.department.major;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/major")

public class MajorController {

    final private MajorService majorService;



    @PostMapping()
  public MajorDto postMapping( @RequestBody final MajorModel major) {
      return majorService.createMajor(major);
  }
    @GetMapping("/{id}")
    public MajorDto getMapping( @PathVariable final Long id) {
        return majorService.getById(id);
    }

    @PutMapping("/{id}")
    public MajorDto putMapping( @RequestBody final MajorModel majorModel,  @PathVariable final Long id){
        return majorService.updateMajor(majorModel,id);
    }
    @DeleteMapping("/{id}")
    public String deleteMapping( @PathVariable final Long id){
       return majorService.deleteMajor(id);
    }

    @GetMapping("n/{id}")
    public MajorDto getWithDepartment(@PathVariable final Long id){
        return majorService.getWithDepartment(id);
    }

}
