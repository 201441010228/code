package com.zy.code.controller;

import com.schooldesign.demo.dao.*;
import com.schooldesign.demo.entity.Teacher;
import com.schooldesign.demo.utils.ProcessResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class BaseControllor {

    protected  org.slf4j.Logger logger =  LoggerFactory.getLogger(BaseControllor.class);

    @Autowired
    protected ClassInSchoolRespository classInSchoolRespository;

    @Autowired
    protected SchoolRepository schoolRepository;

    @Autowired
    protected ScoreRespository scoreRespository;

    @Autowired
    protected StudentRepository studentRepository;

    @Autowired
    protected SubjectRespository subjectRespository;

    @Autowired
    protected TeacherAndSubjectRepository teacherAndSubjectRepository;

    @Autowired
    protected TeacherRepository teacherRepository;

    @Autowired
    protected UserRepository userRepository;

    protected static void setReturnProcessResult(ProcessResult processResult){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        request.setAttribute("status",processResult.getStatus());
        request.setAttribute("message",processResult.getMessage());
        if (null != processResult.getData()){
            for (Map.Entry<String,Object> data :processResult.getData().entrySet()) {
                request.setAttribute(data.getKey(),data.getValue());
            }
        }
    }
}
