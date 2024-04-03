package com.example.student.module.studnet;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;


@Repository
 public interface StudentRepository extends JpaRepository <Student,Long>{
    Student findStudentById(Long id);

    @Query("SELECT s FROM Student s  JOIN FETCH s.major WHERE s.id=:id")
    Student findIdWithMajor(Long id);


    @Query("SELECT s FROM Student s")
    Page<Student> findAll(final Pageable page);


   @Query("SELECT c.name FROM Course c JOIN Enroll e on e.courseId = c.id WHERE e.studentId= :id")
   List<String> getStudentCourses(Long id);


}

