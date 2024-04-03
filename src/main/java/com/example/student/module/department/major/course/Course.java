package com.example.student.module.department.major.course;


import com.example.student.framework.model.EntityMeta;
import com.example.student.module.enroll.Enroll;
import com.example.student.module.department.major.Major;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Course extends EntityMeta  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ_generator")
    @SequenceGenerator(name = "COURSE_SEQ_generator", sequenceName = "COURSE_SEQ", allocationSize = 1)

    private Long id;
    private String name;
    private Long majorId;



    @OneToMany(fetch = FetchType.LAZY)
   List<Enroll> enroll;


    @ManyToOne
    @JoinColumn(name = "majorId", referencedColumnName = "id", insertable = false, updatable = false)
    private Major major;




}