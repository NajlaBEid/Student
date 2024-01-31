package com.example.student.module.major;

import com.example.student.framework.model.DtoMeta;
import com.example.student.module.studnet.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter


public class MajorDto extends DtoMeta {
    private Long id;

    private String majorCode;

    private String name;

    private List<Student> students;

}
