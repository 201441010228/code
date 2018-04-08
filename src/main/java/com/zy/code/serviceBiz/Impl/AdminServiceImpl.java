package com.zy.code.serviceBiz.Impl;

import com.zy.code.entity.*;
import com.zy.code.serviceBiz.AdminService;
import com.zy.code.utils.CodeMessageConstants;
import com.zy.code.utils.ProcessResult;
import com.zy.code.utils.ProcessResultReturnUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {


    @Override
    public ProcessResult saveStudent(Student student) {
        Student student1 = studentRepository.save(student);
        if (null != student1){
            return ProcessResultReturnUtil.successProcessResult();
        }
        return ProcessResultReturnUtil.saveFailProcessResult();
    }

    @Override
    public ProcessResult deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return ProcessResultReturnUtil.successProcessResult();
    }


    @Override
    public ProcessResult saveSubject(Subject subject) {
        Subject subject1 = subjectRespository.save(subject);
        if (null != subject1){
            return ProcessResultReturnUtil.successProcessResult();
        }
        return ProcessResultReturnUtil.saveFailProcessResult();
    }

    @Override
    public ProcessResult deleteSubject(Long subjectId) {
        subjectRespository.deleteById(subjectId);
        return ProcessResultReturnUtil.successProcessResult();
    }


    @Override
    public ProcessResult saveTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public ProcessResult deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return ProcessResultReturnUtil.successProcessResult();
    }


    @Override
    public ProcessResult saveScore(Score score) {
      Score score1 =  scoreRespository.save(score);
      if (null != score1){
          ProcessResultReturnUtil.successProcessResult();
      }
       return ProcessResultReturnUtil.failProcessResult();
    }

    @Override
    public ProcessResult deleteScore(Long scoreId) {
        scoreRespository.deleteById(scoreId);
        return ProcessResultReturnUtil.successProcessResult();
    }


    @Override
    public ProcessResult saveTeacherAndSubject(TeacherAndSubject teacherAndSubject) {
       TeacherAndSubject teacherAndSubject1 = teacherAndSubjectRepository.save(teacherAndSubject);
       if (null != teacherAndSubject1){
           ProcessResultReturnUtil.successProcessResult();
       }
       return ProcessResultReturnUtil.failProcessResult();
    }

    @Override
    public ProcessResult deleteTeacherAndSubject(Long teacherAndSubjectId) {
        teacherAndSubjectRepository.deleteById(teacherAndSubjectId);
        return ProcessResultReturnUtil.successProcessResult();
    }

    @Override
    public ProcessResult saveSchool(School school) {
        School school1 = schoolRepository.save(school);
        if (null != school1){
            ProcessResultReturnUtil.successProcessResult();
        }
        return ProcessResultReturnUtil.failProcessResult();
    }

    @Override
    public ProcessResult deleteSchool(Long schoolId) {
        schoolRepository.deleteById(schoolId);
        return ProcessResultReturnUtil.successProcessResult();
    }

    @Override
    public ProcessResult saveClassInSchool(ClassInSchool classInSchool) {
      ClassInSchool classInSchool1 =  classInSchoolRespository.save(classInSchool);
        if (null != classInSchool1){
            ProcessResultReturnUtil.successProcessResult();
        }
        return ProcessResultReturnUtil.failProcessResult();
    }

    @Override
    public ProcessResult deleteClassInSchool(Long classInSchoolId) {
        classInSchoolRespository.deleteById(classInSchoolId);
        return ProcessResultReturnUtil.successProcessResult();
    }

    @Override
    public ProcessResult login(Teacher teacher) {
       ProcessResult processResult = new ProcessResult();
        Teacher teacher1 = teacherRepository.findByTeacherName(teacher.getTeacherName());
       if (teacher1!=null && teacher1.getPassword().equals(teacher1.getPassword())){
           processResult.setStatus(CodeMessageConstants.SUCCESS.getStatus());
       }
       return ProcessResultReturnUtil.failProcessResult();
    }

}
