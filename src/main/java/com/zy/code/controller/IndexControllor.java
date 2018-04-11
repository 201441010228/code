package com.zy.code.controller;

import com.zy.code.entity.School;
import com.zy.code.entity.Teacher;
import com.zy.code.utils.CodeMessageConstants;
import com.zy.code.utils.ProcessResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexControllor extends BaseControllor{


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcom(){
        return "welcom";
    }

    @RequestMapping(value = "/toregister",method = RequestMethod.GET)
    public String toregister(){
        return "registerView/register";
    }

    @RequestMapping(value = "/toregisterSchool",method = RequestMethod.GET)
    public String toregisterSchool(){
        return "registerView/registerSchool";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "teacherName",required = false) String teacherName,
                        @RequestParam(value = "password",required = false) String password){
        ModelAndView modelAndView = new ModelAndView();
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setPassword(password);
        ProcessResult processResult = adminService.login(teacher);
        if (processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())) {
            modelAndView.setViewName("register");
        }else{
            modelAndView.setViewName("welcom");
        }
        setReturnProcessResult(processResult);
        return modelAndView;
    }

    @RequestMapping(value = "/registSchool",method = RequestMethod.GET)
    public String regist(@RequestParam(value = "schoolName",required = false) String schoolName,
                               @RequestParam(value = "province",required = false) String province,
                               @RequestParam(value = "city",required = false) String city,
                               @RequestParam(value = "area",required = false) String area,
                               @RequestParam(value = "address",required = false) String address,
                               @RequestParam(value = "phoneNumber",required = false) String phoneNumber
                             ){
        School school = new School();
        school.setSchoolName(schoolName);
        school.setProvince(province);
        school.setCity(city);
        school.setArea(area);
        school.setAddress(address);
        school.setPhoneNumber(phoneNumber);
        ProcessResult processResult =  adminService.saveSchool(school);
        if(processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())){
            return "register";
        }
        return "error";
    }
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public ModelAndView regist(@RequestParam(value = "teachername",required = false) String username,
                         @RequestParam(value = "password",required = false) String password,
                         @RequestParam(value = "province",required = false) String province,
                         @RequestParam(value = "city",required = false) String city,
                         @RequestParam(value = "area",required = false) String area,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "phone",required = false) String phone,
                         @RequestParam(value = "sex",required = false) String sex){
        ModelAndView modelAndView = new ModelAndView();
        Teacher teacher = new Teacher();
        teacher.setTeacherName(username);
        teacher.setPassword(password);
        ProcessResult processResult = adminService.login(teacher);
        if (processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())) {
            modelAndView.setViewName("register");
        }
        setReturnProcessResult(processResult);
        modelAndView.setViewName("welcom");
        return modelAndView;
    }



}
