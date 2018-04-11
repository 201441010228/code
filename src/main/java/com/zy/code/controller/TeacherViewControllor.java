package com.zy.code.controller;

import com.zy.code.entity.*;
import com.zy.code.utils.ProcessResult;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
public class TeacherViewControllor extends BaseControllor {

    /**
     * 根据年份和期中期末查询成绩
     *
     * @param studentId
     * @param year
     * @param midOrEnd
     * @return
     */
    @RequestMapping(value = "/getStudentCompareClass", method = RequestMethod.GET)
    public ProcessResult index(@Param("studentId") Long studentId,
                                  @Param("year") Integer year,
                                  @Param("midOrEnd") Integer midOrEnd) {
        ProcessResult processResult = teacherService.getStudentScoreCompareClassAvg(studentId, year, midOrEnd);
        return processResult;
    }

    @RequestMapping(value = "/getTeacherListBySchoolId",method = RequestMethod.GET)
    public ModelAndView getTeacherListBySchoolId(@RequestParam(value = "schoolId", required = false) Long schoolId
                   ,ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        ProcessResult processResult = adminService.getTeacherListBySchoolId(schoolId);
        List<Teacher> teacherList = (List<Teacher>)processResult.getData().get("teacherList");
        modelMap.addAttribute("teacherList",teacherList);
        ProcessResult processResult2 = adminService.getSchoolList();
        List<School> schoolList = (List<School>)processResult2.getData().get("schoolList");
        modelMap.addAttribute("schoolList",schoolList);
        modelMap.addAttribute("schoolId",schoolId);
        modelAndView.setViewName("registerView/registerClass");
        return modelAndView;
    }

    @RequestMapping(value = "/getClassListBySchoolId",method = RequestMethod.GET)
    public ModelAndView getClassListBySchoolId(@RequestParam(value = "schoolId", required = false) Long schoolId
            , ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        ProcessResult processResult = adminService.getClassListBySchoolId(schoolId);
        List<ClassInSchool> classList = (List<ClassInSchool>)processResult.getData().get("classList");
        modelMap.addAttribute("classList",classList);
        ProcessResult processResult2 = adminService.getSchoolList();
        List<School> schoolList = (List<School>)processResult2.getData().get("schoolList");
        modelMap.addAttribute("schoolList",schoolList);
        modelMap.addAttribute("schoolId",schoolId);
        modelAndView.setViewName("registerView/registerStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/getClassListBySchoolIdTwo",method = RequestMethod.GET)
    public ModelAndView getClassListBySchoolIdTwo(@RequestParam(value = "schoolId", required = false) Long schoolId
            , ModelMap modelMap){
       ModelAndView modelAndView = getClassListBySchoolId(schoolId,modelMap);
        modelAndView.setViewName("admin/submitScore");
        return modelAndView;
    }


    @RequestMapping(value = "/getStudentListByClassId",method = RequestMethod.GET)
    public ModelAndView getStudentListByClassId(@RequestParam(value = "classInSchoolId", required = false) Long classInSchoolId
            , ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        ClassInSchool classInSchool1 = adminService.getClassInSchoolById(classInSchoolId);
        ProcessResult processResult = adminService.getClassListBySchoolId(classInSchool1.getSchoolId());
        List<ClassInSchool> classList = (List<ClassInSchool>)processResult.getData().get("classList");
        modelMap.addAttribute("classList",classList);
        ProcessResult processResult2 = adminService.getSchoolList();
        List<School> schoolList = (List<School>)processResult2.getData().get("schoolList");
        modelMap.addAttribute("schoolList",schoolList);
        List<Student> studentList = adminService.getAllStudentByClassInSchoolId(classInSchoolId);
        List<Subject> subjectList = adminService.getAllSubjectByClassInSchooluId(classInSchool1.getSchoolId());
        modelMap.addAttribute("subjectList",subjectList);
        modelMap.addAttribute("studentList",studentList);
        modelMap.addAttribute("schoolId",classInSchool1.getSchoolId());
        modelMap.addAttribute("classInSchoolId",classInSchool1.getId());
        modelAndView.setViewName("admin/submitScore");
        return modelAndView;
    }



}
