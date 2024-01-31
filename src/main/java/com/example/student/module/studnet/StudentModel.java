package com.example.student.module.studnet;

import com.example.student.framework.model.ModelMeta;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
public class StudentModel extends ModelMeta {

    private String name;
    private Long majorId;


}
