package com.example.student.module.major;

import com.example.student.framework.model.EntityMeta;
import com.example.student.module.studnet.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.util.List;

@Setter
@Getter
@Entity
@Where(clause = "deleted = 0")
@ToString
public class Major extends EntityMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAJOR_SEQ_generator")
    @SequenceGenerator(name = "MAJOR_SEQ_generator", sequenceName = "MAJOR_SEQ", allocationSize = 1)
    private Long id;
    private String majorCode;
    private String name;

}
