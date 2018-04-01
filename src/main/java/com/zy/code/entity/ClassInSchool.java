package com.zy.code.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassInSchoolName() {
        return classInSchoolName;
    }

    public void setClassInSchoolName(String classInSchoolName) {
        this.classInSchoolName = classInSchoolName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getChineseTeacherId() {
        return chineseTeacherId;
    }

    public void setChineseTeacherId(Long chineseTeacherId) {
        this.chineseTeacherId = chineseTeacherId;
    }

    public Long getMathTeacherId() {
        return mathTeacherId;
    }

    public void setMathTeacherId(Long mathTeacherId) {
        this.mathTeacherId = mathTeacherId;
    }

    public Long getEnglishTeacherId() {
        return englishTeacherId;
    }

    public void setEnglishTeacherId(Long englishTeacherId) {
        this.englishTeacherId = englishTeacherId;
    }

    public Long getPhysicsTeacherId() {
        return physicsTeacherId;
    }

    public void setPhysicsTeacherId(Long physicsTeacherId) {
        this.physicsTeacherId = physicsTeacherId;
    }

    public Long getChemistryTeacherId() {
        return chemistryTeacherId;
    }

    public void setChemistryTeacherId(Long chemistryTeacherId) {
        this.chemistryTeacherId = chemistryTeacherId;
    }

    public Long getHistoryTeacherId() {
        return historyTeacherId;
    }

    public void setHistoryTeacherId(Long historyTeacherId) {
        this.historyTeacherId = historyTeacherId;
    }

    public Long getPoliticalTeacherId() {
        return politicalTeacherId;
    }

    public void setPoliticalTeacherId(Long politicalTeacherId) {
        this.politicalTeacherId = politicalTeacherId;
    }

    public Long getComputerTeacherId() {
        return computerTeacherId;
    }

    public void setComputerTeacherId(Long computerTeacherId) {
        this.computerTeacherId = computerTeacherId;
    }

    public Long getSportsTeacherId() {
        return sportsTeacherId;
    }

    public void setSportsTeacherId(Long sportsTeacherId) {
        this.sportsTeacherId = sportsTeacherId;
    }

    public ClassInSchool() {

    }
}
