package com.example.student.module.department;

import com.example.student.framework.mapping.StructMapper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DepartmentMapper  extends StructMapper<Department, DepartmentModel, DepartmentDto> {

    Department modelToEntity(final DepartmentModel model, @MappingTarget final Department target);
    @Named("toEntity")
    @Mapping(target = "majors", ignore = true)
    Department toEntity(final DepartmentModel model);

    @Named("toDto")
    @Mapping(target = "majors", ignore = true)
    DepartmentDto toDto(final Department save);


}
