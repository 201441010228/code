package com.zy.code.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {

    @Id
    @GeneratedValue
    private  Long id;

    private Long subjectId;

    private Long studentId;

    private Double scoreNumber;   //分数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Double getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(Double scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

    public Score() {
    }
}
