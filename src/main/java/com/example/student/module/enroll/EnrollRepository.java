package com.example.student.module.enroll;

import com.example.student.module.studnet.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EnrollRepository extends JpaRepository <Enroll,Long> {

    @Query("SELECT e.id FROM Enroll e  WHERE e.studentId=:studentId and e.courseId=:courseId")
    Long findEnrollment(Long studentId, Long courseId);

    @Query("SELECT e FROM Enroll e  WHERE e.studentId=:studentId and e.courseId=:courseId")
    Enroll findEnroll(Long studentId, Long courseId);


}
