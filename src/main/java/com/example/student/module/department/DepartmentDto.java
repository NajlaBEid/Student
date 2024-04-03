package com.example.student.module.department;

import com.example.student.framework.model.DtoMeta;
import com.example.student.module.department.major.MajorDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class DepartmentDto extends DtoMeta {

    private Long id;
    private String name;
    private List<MajorDto> majors;



}
