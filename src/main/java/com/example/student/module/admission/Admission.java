package com.example.student.module.admission;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Admission {
    @Id
    private Long id;
    private String name;
}
