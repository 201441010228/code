package com.zy.code.controller;

import com.zy.code.entity.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class adminControllor extends BaseControllor {

    @RequestMapping(value = {"/saveUser","/updateUser"},method = RequestMethod.GET)
    public ModelAndView saveUser(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return  modelAndView;
    }


    @GetMapping(value = "/saveStudent")
    public String saveStudent(){
        Student student = new Student();
        adminService.saveStudent(student);
        return "success";
    }

    @GetMapping(value = "/saveTeacher")
    public String saveTeacher(){
        Teacher teacher = new Teacher();
        adminService.saveTeacher(teacher);
        return "success";
    }

    @GetMapping(value = "/saveSchool")
    public String saveSchool(){
        School school = new School();
        adminService.saveSchool(school);
        return "success";
    }

    @GetMapping(value = "/saveClassInSchool")
    public String saveClassInSchool(){
        ClassInSchool classInSchool = new ClassInSchool();
        adminService.saveClassInSchool(classInSchool);
        return "success";
    }

    @GetMapping(value = "/saveScore")
    public String saveScore(){
        Score score = new Score();
        adminService.saveScore(score);
        return "success";
    }

    @GetMapping(value = "/saveSubject")
    public String saveSubject(){
        Subject subject = new Subject();
        adminService.saveSubject(subject);
        return "success";
    }
}
