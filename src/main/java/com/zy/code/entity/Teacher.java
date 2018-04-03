package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue
    private  Long id;

    private  String teacherName;   //老师名字

    private  String province;  //省

    private  String city;   //市

    private  String area;  //区

    private  String address; //详细地址

    private  String phoneNumber; //联系电话

    private  Integer level;   //级别权限控制

    private  Integer status;  //1 正常 0 冻结

    private String password; //密码

    private Integer sex;   //0女 1男

    private Long schoolId; //学校Id


    public Teacher() {
    }
}
