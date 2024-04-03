package com.example.student.module.department.major;

import com.example.student.framework.model.EntityMeta;
import com.example.student.module.department.major.course.Course;
import com.example.student.module.department.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Setter
@Getter
@Entity
@ToString
public class Major extends EntityMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAJOR_SEQ_generator")
    @SequenceGenerator(name = "MAJOR_SEQ_generator", sequenceName = "MAJOR_SEQ", allocationSize = 1)
    private Long id;
    private String majorCode;
    private String name;
    private Long departmentId;



    @ManyToOne(optional = false)
    @JoinColumn(name = "departmentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Department department;




    @OneToMany(mappedBy = "major",fetch = FetchType.LAZY)
    private Set<Course> courses;

}
