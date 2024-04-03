package com.example.student.module.department.major.course;

import com.example.student.framework.model.ModelMeta;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseModel extends ModelMeta {

    private String name;
    private Long majorId;

}
