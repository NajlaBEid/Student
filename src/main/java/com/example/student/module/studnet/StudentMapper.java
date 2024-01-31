package com.example.student.module.studnet;

import com.example.student.framework.mapping.StructMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper extends StructMapper<Student, StudentModel, StudentDto> {

    @Mapping(target = "major", ignore = true)
    Student modelToEntity(final StudentModel model, @MappingTarget final Student target);
    @Mapping(target = "major", ignore = true)
    Student toEntity(final StudentModel model);

    @Named("toDto")
    @Mapping(target = "major", ignore = true)
    StudentDto toDto(final Student save);
}
