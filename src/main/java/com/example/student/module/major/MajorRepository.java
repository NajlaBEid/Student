package com.example.student.module.major;

import com.example.student.module.studnet.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
 interface MajorRepository extends JpaRepository<Major,Long> {
    public Major findMajorById(Long id);




}
