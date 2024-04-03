package com.example.student.module.department.major;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorStudentProxy {

    @Qualifier("majorMapper")
    final private MajorMapper mapper;


    public MajorDto getMajor (Major major) {
        MajorDto majorDto = this.mapper.toDto(major);
        return majorDto;
    }

}
