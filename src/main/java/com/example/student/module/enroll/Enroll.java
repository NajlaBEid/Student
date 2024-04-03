package com.example.student.module.enroll;
import com.example.student.module.department.major.course.Course;
import com.example.student.module.studnet.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter

public class Enroll  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Enroll_SEQ_generator")
    @SequenceGenerator(name = "Enroll_SEQ_generator", sequenceName = "ENROLL_SEQ", allocationSize = 1)
    private Long id;

    private Long studentId;

    private Long courseId;

    @ToString.Exclude
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;



}
