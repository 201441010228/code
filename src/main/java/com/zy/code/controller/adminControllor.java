package com.zy.code.controller;

import com.zy.code.entity.*;
import com.zy.code.utils.ProcessResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminControllor extends BaseControllor {

    @GetMapping(value = "/saveUser")
    public ProcessResult saveUser(){
        User user = new User();
        user.setName("小名");
        return  adminService.saveUser(user);
    }


//    @GetMapping(value = "/saveStudent")
//    public String saveStudent(){
//        Student student = new Student();
//        studentRepository.save(student);
//        return "success";
//    }
//
//    @GetMapping(value = "/saveTeacher")
//    public String saveTeacher(){
//        Teacher teacher = new Teacher();
//        teacherRepository.save(teacher);
//        return "success";
//    }
//
//    @GetMapping(value = "/saveSchool")
//    public String saveSchool(){
//        School school = new School();
//        schoolRepository.save(school);
//        return "success";
//    }
//
//    @GetMapping(value = "/saveClassInSchool")
//    public String saveClassInSchool(){
//        ClassInSchool classInSchool = new ClassInSchool();
//        classInSchoolRespository.save(classInSchool);
//        return "success";
//    }
//
//    @GetMapping(value = "/saveScore")
//    public String saveScore(){
//        Score score = new Score();
//        scoreRespository.save(score);
//        return "success";
//    }
//
//    @GetMapping(value = "/saveSubject")
//    public String saveSubject(){
//        Subject subject = new Subject();
//        subjectRespository.save(subject);
//        return "success";
//    }
}
