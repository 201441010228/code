package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class TeacherAndSubject {

    @Id
    @GeneratedValue
    private  Long id;

    private Long teacherId;

    private Long subjectId;

    private Long schoolId;

}
