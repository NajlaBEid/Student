package com.example.student.module.department;

import com.example.student.module.studnet.Student;
import com.example.student.module.studnet.StudentDto;
import com.example.student.module.studnet.StudentModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;
    @Qualifier("departmentMapper")
    private final DepartmentMapper mapper;

    public DepartmentDto create(DepartmentModel model){
        Department department = this.mapper.toEntity(model);
        this.repository.save(department);
        DepartmentDto departmentDto = this.mapper.toDto(department);
        return departmentDto;
    }


    public DepartmentDto get(Long id){
        Department department = repository.findDepartmentById(id);
        DepartmentDto departmentDto = this.mapper.toDto(department);
        return departmentDto;
    }
    public DepartmentDto update(DepartmentModel model, Long id){
        Department department = repository.findDepartmentById(id);
        department = this.mapper.modelToEntity(model,department);
        this.repository.save(department);
        DepartmentDto departmentDto = this.mapper.toDto(department);
        return departmentDto;
    }

    public String delete(Long id){
        this.repository.findDepartmentById(id);
        this.repository.deleteById(id);
        return "Department with Id " + id+" deleted";
    }


}


















