package com.zy.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
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

}
