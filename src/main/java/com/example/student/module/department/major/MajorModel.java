package com.example.student.module.department.major;

import com.example.student.framework.model.ModelMeta;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class MajorModel extends ModelMeta {

    private String majorCode;

    private String name;

    private Long departmentId;


}
