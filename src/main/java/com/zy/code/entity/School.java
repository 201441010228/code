package com.zy.code.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;    //编号

    private String schoolName; //学校名称

    private  String province;  //省

    private  String city;   //市

    private  String area;  //区

    private  String address; //详细地址

    private  String phoneNumber; //联系电话

    private  Integer status; //学校状态

    private  Integer level;  //学校级别 0 小学 1 初中 2 高中 3 大学

    private  Long schoolMasterId; //校长

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getSchoolMasterId() {
        return schoolMasterId;
    }

    public void setSchoolMasterId(Long schoolMasterId) {
        this.schoolMasterId = schoolMasterId;
    }

    public School() {
    }
}
