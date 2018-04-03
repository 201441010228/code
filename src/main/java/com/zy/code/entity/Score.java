package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Score {

    @Id
    @GeneratedValue
    private  Long id;

    private Long subjectId;

    private Long studentId;

    private Double scoreNumber;   //分数

}
