package com.example.student.module.studnet;

import com.example.student.framework.mapping.StructMapper;

import com.example.student.module.department.major.MajorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;

@Mapper
@Component
 public interface StudentMapper extends StructMapper<Student, StudentModel, StudentDto> {


    @Mapping(target = "major", ignore = true)
    Student modelToEntity(final StudentModel model, @MappingTarget final Student target);

    @Named("toEntity")
    @Mapping(target = "major", ignore = true)
    Student toEntity(final StudentModel model);

    @Named("toDto")
    @Mapping(target = "major", ignore = true)
    StudentDto toDto(final Student save);


    default StudentDto toDtoWithMajor(final Student student, MajorDto majorDto){
       StudentDto studentDto = this.toDto(student);
        studentDto.setMajor(majorDto);
       return studentDto;

    }
   default Page<StudentDto> toPage(final Page<Student> save) {
        return save.map(this::toDto);
    }

}
