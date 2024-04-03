package com.example.student.module.department;

import com.example.student.framework.model.EntityMeta;
import com.example.student.module.department.major.Major;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Department extends EntityMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEP_SEQ_generator")
    @SequenceGenerator(name = "DEP_SEQ_generator", sequenceName = "DEP_SEQ", allocationSize = 1)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private List<Major> majors;



}
