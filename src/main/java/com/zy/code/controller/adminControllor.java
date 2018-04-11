package com.zy.code.controller;

import com.zy.code.entity.*;
import com.zy.code.utils.CodeMessageConstants;
import com.zy.code.utils.ProcessResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class adminControllor extends BaseControllor {


    @RequestMapping(value = "/registSchool",method = RequestMethod.GET)
    public String registSchool(@RequestParam(value = "schoolName",required = false) String schoolName,
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
        saveSubject(Long.parseLong(processResult.getData().get("schoolId").toString()),"语文");
        saveSubject(Long.parseLong(processResult.getData().get("schoolId").toString()),"数学");
        saveSubject(Long.parseLong(processResult.getData().get("schoolId").toString()),"英语");
        if(processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())){
            return "registerView/register";
        }
        return "error";
    }


    @RequestMapping(value = "/registTeacher",method = RequestMethod.GET)
    public String registTeacher(@RequestParam(value = "teacherName",required = false) String teacherName,
                                @RequestParam(value = "province", required = false) String province,
                                @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "area", required = false) String area,
                                @RequestParam(value = "address", required = false) String address,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                @RequestParam(value = "sex", required = false) Integer sex,
                                @RequestParam(value = "schoolId", required = false) Long schoolId){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setProvince(province);
        teacher.setCity(city);
        teacher.setArea(area);
        teacher.setAddress(address);
        teacher.setPhoneNumber(phoneNumber);
        teacher.setPassword(password);
        teacher.setSex(sex);
        teacher.setSchoolId(schoolId);
        ProcessResult processResult =  adminService.saveTeacher(teacher);
        if(processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())){
            return "registerView/register";
        }
        return "error";
    }


    @RequestMapping(value = "/registClass",method = RequestMethod.GET)
    public String registClass(@RequestParam(value = "className",required = false) String className,
                              @RequestParam(value = "schoolId", required = false) Long schoolId,
                              @RequestParam(value = "chineseTeacherId", required = false) Long chineseTeacherId,
                              @RequestParam(value = "mathTeacherId", required = false) Long mathTeacherId,
                              @RequestParam(value = "englishTeacherId", required = false) Long englishTeacherId,
                              @RequestParam(value = "teacherId", required = false) Long teacherId){
        ClassInSchool classInSchool = new ClassInSchool();
        classInSchool.setTeacherId(teacherId);
        classInSchool.setChineseTeacherId(chineseTeacherId);
        classInSchool.setMathTeacherId(mathTeacherId);
        classInSchool.setEnglishTeacherId(englishTeacherId);
        classInSchool.setSchoolId(schoolId);
        classInSchool.setClassInSchoolName(className);
        ProcessResult processResult =  adminService.saveClassInSchool(classInSchool);
        if(processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())){
            return "registerView/register";
        }
        return "error";
    }
    
    private void saveSubject(Long schoolId,String subjectName){
        Subject subject = new Subject();
        subject.setFullMarks(100D);
        subject.setSchoolId(schoolId);
        subject.setSubjectName(subjectName);
        subject.setWarningScore(60D);
        adminService.saveSubject(subject);
    }


    @RequestMapping(value = "/registStudent",method = RequestMethod.GET)
    public String registStudent(@RequestParam(value = "studentName",required = false) String studentName,
                                @RequestParam(value = "province", required = false) String province,
                                @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "area", required = false) String area,
                                @RequestParam(value = "address", required = false) String address,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                @RequestParam(value = "sex", required = false) Integer sex,
                                @RequestParam(value = "schoolId", required = false) Long schoolId,
                                @RequestParam(value = "classInSchoolId", required = false) Long classInSchoolId,
                                @RequestParam(value = "year", required = false) Integer year){
        Student student = new Student();
        student.setStudentName(studentName);
        student.setProvince(province);
        student.setCity(city);
        student.setArea(area);
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        student.setPassword(password);
        student.setSex(sex);
        student.setSchoolId(schoolId);
        student.setClassInSchoolId(classInSchoolId);
        student.setYear(year);
        ProcessResult processResult =  adminService.saveStudent(student);
        if(processResult.getStatus().equals(CodeMessageConstants.SUCCESS.getStatus())){
            return "registerView/register";
        }
        return "error";
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
    public String saveScore(@RequestParam(value = "schoolId", required = false) Long schoolId,
                            @RequestParam(value = "classInSchoolId", required = false) Long classInSchoolId,
                            @RequestParam(value = "studentId", required = false) Long studentId,
                            @RequestParam(value = "chineseSubject", required = false) Double chineseSubject,
                            @RequestParam(value = "mathSubject", required = false) Double mathSubject,
                            @RequestParam(value = "englishSubject", required = false) Double englishSubject,
                            @RequestParam(value = "year", required = false) Integer year,
                            @RequestParam(value = "midOrEnd", required = false) Integer midOrEnd){
       List<Subject> subjectList = adminService.getAllSubjectByClassInSchooluId(schoolId);
        for (Subject subject : subjectList) {
            Score score = new Score();
            score.setStudentId(studentId);
            score.setMidOrEnd(midOrEnd);
            score.setYear(year);
            score.setSubjectId(subject.getId());
            if ("语文".equals(subject.getSubjectName())) {
                score.setScoreNumber(chineseSubject);
            } else if ("数学".equals(subject.getSubjectName())) {
                score.setScoreNumber(mathSubject);
            } else {
                score.setScoreNumber(englishSubject);
            }
            adminService.saveScore(score);
        }
        return "admin/loginSuccess";
    }

    @GetMapping(value = "/saveSubject")
    public String saveSubject(){
        Subject subject = new Subject();
        adminService.saveSubject(subject);
        return "success";
    }
}
