package com.example.student.module.department.major;


import com.example.student.module.department.DepartmentDto;
import com.example.student.module.department.DepartmentMajorProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;
    @Qualifier("majorMapper")
    private final MajorMapper mapper;
    private final DepartmentMajorProxy departmentMajorProxy;
    public MajorDto createMajor(final MajorModel majorModel) {
        Major major = this.mapper.toEntity(majorModel);
        this.majorRepository.save(major);
        MajorDto majorDto = this.mapper.toDto(major);
        return majorDto;

    }
        public MajorDto getById (final Long id) {
        Major major = majorRepository.findMajorById(id);
       MajorDto majorDto = this.mapper.toDto(major);
        return majorDto;
    }


    public MajorDto updateMajor(final MajorModel majorModel, Long id){
        Major major = majorRepository.findMajorById(id);
        major = this.mapper.modelToEntity(majorModel,major);
        this.majorRepository.save(major);
        MajorDto majorDto = this.mapper.toDto(major);
        return  majorDto;
    }
        public String deleteMajor(Long id){

        majorRepository.deleteById(id);
          return  "Major with ID "+id+" deleted";
    }

    public MajorDto getWithDepartment(final Long id){
        Major major = this.majorRepository.findMajorById(id);
        DepartmentDto departmentDto = this.departmentMajorProxy.getDepartment(major.getDepartment());
        return this.mapper.toDtoWithDepartment(major,departmentDto);

    }

    }

