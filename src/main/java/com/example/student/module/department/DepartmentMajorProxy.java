package com.example.student.module.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentMajorProxy {
    private final DepartmentMapper mapper;

    public DepartmentDto getDepartment (Department department) {
        DepartmentDto departmentDto = this.mapper.toDto(department);
        return departmentDto;
    }
}
