package com.example.student.module.department.major;

import com.example.student.framework.model.DtoMeta;
import com.example.student.module.department.major.course.CourseDto;
import com.example.student.module.department.DepartmentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter

public class MajorDto extends DtoMeta {
    private Long id;

    private String majorCode;

    private String name;

    private Long departmentId;

    private DepartmentDto department;

    private Set<CourseDto> course;


}
