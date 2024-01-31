package com.example.student.module.studnet;

import com.example.student.framework.model.DtoMeta;
import com.example.student.module.major.Major;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto extends DtoMeta {

    private Long id;

    private String name;

    private Long majorId;

    private Major major;


}
