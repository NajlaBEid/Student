package com.example.student.module.major;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;
    private final MajorMapper mapper;

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

    }

