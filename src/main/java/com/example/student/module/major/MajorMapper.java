package com.example.student.module.major;

import com.example.student.framework.mapping.StructMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
@Mapper
@Component
public interface MajorMapper extends StructMapper <Major, MajorModel, MajorDto> {

    Major modelToEntity(final MajorModel model, @MappingTarget final Major target);
    @Named("toEntity")
    Major toEntity(final MajorModel model);

    @Named("toDto")
    MajorDto toDto(final Major save);
}
