package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue
    private  Long id;

    private  String subjectName;   //科目名字

    private  Long schoolId; //学校ID

    private  Double warningScore; //警告分数

    private  Integer level; //是否为主科 1是 0 否

    private  Integer status;

    private  Double fullMarks; //满分

}
