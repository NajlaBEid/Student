package com.example.student.module.studnet;

import com.example.student.framework.model.EntityMeta;
import com.example.student.module.enroll.Enroll;
import com.example.student.module.department.major.Major;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.util.List;


@Setter
@Getter
@Entity
@Where (clause = "deleted = 0")
@ToString
public class Student extends EntityMeta  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ_generator")
    @SequenceGenerator(name = "STUDENT_SEQ_generator", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    private Long majorId;


    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId", referencedColumnName = "id", insertable = false, updatable = false)
    private Major major;


    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY)
       List<Enroll> enroll;



}