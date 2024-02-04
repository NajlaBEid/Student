package com.example.student.module.major;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorStudentProxy {

    final private MajorRepository majorRepository;
    final private MajorMapper mapper;

    public MajorDto getMajorById (final Long id) {
        Major major = majorRepository.findMajorById(id);
        MajorDto majorDto = this.mapper.toDto(major); // convert it to dto
        return majorDto;
    }
}
