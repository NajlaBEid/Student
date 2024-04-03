package com.example.student.module.department.major;

import com.example.student.framework.mapping.StructMapper;
import com.example.student.module.department.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
@Mapper
@Component
  public interface MajorMapper extends StructMapper <Major, MajorModel, MajorDto> {

  @Mapping(target = "department", ignore = true)
    Major modelToEntity(final MajorModel model, @MappingTarget final Major target);
    @Named("toEntity")
    @Mapping(target = "department", ignore = true)
    Major toEntity(final MajorModel model);

    @Named("toDto")
    @Mapping(target = "department", ignore = true)
    MajorDto toDto(final Major save);

  default MajorDto toDtoWithDepartment(final Major major, DepartmentDto departmentDto){
    MajorDto majorDto = this.toDto(major);
    majorDto.setDepartment(departmentDto);
    return majorDto;

  }


}
