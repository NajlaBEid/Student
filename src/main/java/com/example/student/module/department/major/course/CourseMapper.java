package com.example.student.module.department.major.course;
import com.example.student.framework.mapping.StructMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;


@Mapper
@Component

public interface CourseMapper extends StructMapper<Course,CourseModel,CourseDto> {

    Course modelToEntity(final CourseModel model, @MappingTarget final Course target);
    @Named("toEntity")
    Course toEntity(final CourseModel model);

    @Named("toDto")
    CourseDto toDto(final Course save);

    default Page<CourseDto> toPage(final Page<Course> save){
        return save.map(this::toDto);
    }
}
