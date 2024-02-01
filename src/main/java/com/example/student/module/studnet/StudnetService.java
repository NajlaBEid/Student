package com.example.student.module.studnet;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudnetService {

    private final StudentRepository repository;

    @Qualifier("studentMapper")
    private final StudentMapper mapper;

    public StudentDto createStudent(StudentModel studentModel) {
        //convert model to entity - save
        Student student = this.mapper.toEntity(studentModel);
        this.repository.save(student);

        //convert entity to dto - return
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
    public StudentDto getByIdWithMajor(Long id) {
        Student student = repository.findStudentById(id);
        student = this.repository.findIdWithMajor(id);
        StudentDto studentDTO = this.mapper.toDto(student);
        return studentDTO;
    }

    public Page<StudentDto> getPage(final Pageable page) {

        return this.mapper.toPage(this.repository.findAll(page));
    }


}

//    public StudentDto updateStudentMajor(StudentDto studentDTO, Long id) {
//        Student student = repository.findStudentById(id);
//        student = studentMapper.entity(studentDTO); // convert it to entity
//        student.setMajor(student.getMajor());
//        repository.save(student); // save the entity
//        return studentMapper.DTO(student); // return the dto student
//    }

//

    // Retrieve all student then convert them into dto and return it
//    public List<StudentDto> getAll() {
//        List<Student> studentList = repository.findAll();
//        List<StudentDto> studentDTOList = studentMapper.DTO(studentList);
//        return studentDTOList;
//    }


// public Student updateStudentMajor(Student student, Long id){
//     Student student1= repository.findStudentById(id);
//     student1.setMajor(student.getMajor());
//     repository.save(student1);
//     return student1;
//
// }

//    public Student createStudent(Student student){
//        student.setName(student.getName());
//        //student.setMajor(student.getMajor());
//        repository.save(student);
//        return student;
//
//    }

// without mapping

//    public StudentDto updateStudent(StudentDto studentDto, Long id) {
//        Student student = repository.findStudentById(id);
//        student.setName(studentDto.getName());
//        student.setMajorId(studentDto.getMajorId());
//        this.repository.save(student);
//        studentDto.setName(student.getName());
//        return studentDto;
//    }




