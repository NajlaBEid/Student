package com.example.student.module.studnet;


import com.example.student.module.department.major.MajorDto;
import com.example.student.module.department.major.MajorStudentProxy;
import com.example.student.module.enroll.EnrollStudentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudnetService {

    private final StudentRepository repository;
    private final MajorStudentProxy majorStudentProxy;
    private final StudentMapper mapper;
    private final EnrollStudentProxy enrollStudentProxy;


    public StudentDto createStudent(StudentModel studentModel) {

        Student student = this.mapper.toEntity(studentModel);
        this.repository.save(student);
        StudentDto studentDto = this.mapper.toDto(student);
        return studentDto;
    }
    public StudentDto updateStudent(StudentModel studentModel, Long id) {
        Student student = repository.findStudentById(id);
        student = this.mapper.modelToEntity(studentModel, student);
        this.repository.save(student);
        StudentDto studentDto = this.mapper.toDto(student);
        return studentDto;
    }

    public String deleteId(Long id) {
        repository.deleteById(id);

        return "Student with ID " + id + " deleted";

    }
    public StudentDto getById(Long id) {
        Student student = repository.findStudentById(id);
        StudentDto studentDTO = this.mapper.toDto(student);
        return studentDTO;
    }

        public StudentDto getByIdWithMajor(Long id) {
        Student student = this.repository.findStudentById(id);
        MajorDto majorDto = this.majorStudentProxy.getMajor(student.getMajor());
        return this.mapper.toDtoWithMajor(student,majorDto);

    }

    public Page<StudentDto> getPage(final Pageable page) {

        return this.mapper.toPage(this.repository.findAll(page));
    }

    public List<String> getStudentCourses(final Long id) {
        List<String> enrolledCourses = repository.getStudentCourses(id);
        return enrolledCourses;
    }

    public String enrollInCourse(Long studnetId,Long courseId){
        this.enrollStudentProxy.createEnrollment(studnetId,courseId);
        return "Student Successfully Enrolled";

    }
    public String dropCourse(Long studentId, Long courseId){
        enrollStudentProxy.findEnrollment(studentId,courseId);
        enrollStudentProxy.deleteEnrollment(studentId,courseId);
        return "Student Dropped The Course Successfully";

    }
}



