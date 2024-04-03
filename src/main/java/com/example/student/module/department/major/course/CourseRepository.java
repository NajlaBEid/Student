package com.example.student.module.department.major.course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

 public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findCourseById(Long id);

    @Query("SELECT c from Course c")
    Page<Course> findAll(final Pageable page);

}
