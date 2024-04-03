package com.example.student.module.department;

import com.example.student.framework.model.ModelMeta;
import com.example.student.module.department.major.Major;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
public class DepartmentModel extends ModelMeta {

    private String name;
    private List<Major> majors;


}
