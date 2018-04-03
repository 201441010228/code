package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ClassInSchool {

    @Id
    @GeneratedValue
    private  Long id;

    private  String classInSchoolName;   //班级名字

    private  Long teacherId; //班主任编号

    private  Long schoolId; //学校Id

    private  Long level; //等级 0 小学 1 初中 2 高中 3 大学

    private  Long chineseTeacherId; //语文老师

    private  Long mathTeacherId ; //数学老师

    private  Long englishTeacherId; //英语老师

    private Long physicsTeacherId; //物理老师

    private Long chemistryTeacherId; //化学老师

    private Long historyTeacherId; //历史老师

    private  Long politicalTeacherId; //政治老师

    private Long computerTeacherId; //计算机老师

    private Long sportsTeacherId; //体育老师

}
