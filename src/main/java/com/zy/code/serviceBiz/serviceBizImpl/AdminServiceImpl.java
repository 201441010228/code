package com.zy.code.serviceBiz.serviceBizImpl;

import com.zy.code.entity.*;
import com.zy.code.repository.*;
import com.zy.code.serviceBiz.AdminService;
import com.zy.code.utils.ProcessResult;
import com.zy.code.utils.ProcessResultReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AdminServiceImpl implements AdminService {

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


    @Override
    public ProcessResult saveUser(User user) {
        User returnUser =  userRepository.save(user);
        if (returnUser != null){
           return ProcessResultReturnUtil.successProcessResult();
        }
        return ProcessResultReturnUtil.saveFailProcessResult();
    }


    @Override
    public ProcessResult deleteUser(User user) {
        return null;
    }

    @Override
    public ProcessResult saveStudent(Student student) {
        return null;
    }


    @Override
    public ProcessResult deleteStudent(Student student) {
        return null;
    }

    @Override
    public ProcessResult saveSubject(Subject subject) {
        return null;
    }

    @Override
    public ProcessResult deleteSubject(Subject subject) {
        return null;
    }

    @Override
    public ProcessResult saveTeacher(Teacher teacher) {
        return null;
    }


    @Override
    public ProcessResult deleteTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public ProcessResult saveScore(Score score) {
        return null;
    }


    @Override
    public ProcessResult deleteScore(Score score) {
        return null;
    }

    @Override
    public ProcessResult saveTeacherAndSubject(TeacherAndSubject teacherAndSubject) {
        return null;
    }


    @Override
    public ProcessResult deleteTeacherAndSubject(TeacherAndSubject teacherAndSubject) {
        return null;
    }

    @Override
    public ProcessResult saveSchool(School school) {
        return null;
    }

    @Override
    public ProcessResult deleteSchool(School school) {
        return null;
    }
}
