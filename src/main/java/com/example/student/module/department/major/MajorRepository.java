package com.example.student.module.department.major;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface MajorRepository extends JpaRepository<Major,Long> {
     Major findMajorById(Long id);




}
