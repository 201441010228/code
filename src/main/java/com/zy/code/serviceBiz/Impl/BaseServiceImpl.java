package com.zy.code.serviceBiz.Impl;

import com.zy.code.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class BaseServiceImpl {

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

}
