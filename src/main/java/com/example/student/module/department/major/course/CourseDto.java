package com.example.student.module.department.major.course;


import com.example.student.framework.model.DtoMeta;
import com.example.student.module.department.major.MajorDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDto extends DtoMeta {
    private Long id;
    private String name;
    private Long majorId;
    private MajorDto major;
}
