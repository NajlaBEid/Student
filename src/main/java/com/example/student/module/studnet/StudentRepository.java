package com.example.student.module.studnet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;


@Repository
 interface StudentRepository extends JpaRepository <Student,Long>{
    public Student findStudentById(Long id);
  @Query("SELECT s, m.name AS MAJOR_NAME FROM Student s JOIN Major m  ON s.majorId = m.id WHERE s.id=:id")
  public Student findIdWithMajor(@Param("id") Long id);


    @Query("SELECT s FROM Student s")
    Page<Student> findAll(final Pageable page);





}

