package com.zy.code.controller;

import com.zy.code.entity.Teacher;
import com.zy.code.utils.CodeMessageConstants;
import com.zy.code.utils.ProcessResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexControllor extends BaseControllor{


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcom(HttpServletRequest request){
        return "welcom";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(ModelMap modelMap){
         modelMap.addAttribute("msg","SUCCESS!!!!!!");
         return "show";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "teacherName",required = false) String teacherName,
                        @RequestParam(value = "password",required = false) String password){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setPassword(password);
        ProcessResult processResult = adminService.login(teacher);
        if (processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())) {
            return "choose";
        }
        setReturnProcessResult(processResult);
        return "welcom";
    }

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(@RequestParam(value = "teachername",required = false) String username,
                         @RequestParam(value = "password",required = false) String password,
                         @RequestParam(value = "province",required = false) String province,
                         @RequestParam(value = "city",required = false) String city,
                         @RequestParam(value = "area",required = false) String area,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "phone",required = false) String phone,
                         @RequestParam(value = "sex",required = false) String sex){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(username);
        teacher.setPassword(password);
        ProcessResult processResult = adminService.login(teacher);
        if (processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())) {
            return "choose";
        }
        setReturnProcessResult(processResult);
        return "welcom";
    }



}
