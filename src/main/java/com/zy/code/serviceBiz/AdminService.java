package com.zy.code.serviceBiz;

import com.zy.code.entity.*;
import com.zy.code.utils.ProcessResult;

public interface AdminService {

    ProcessResult saveUser(User user);

    ProcessResult deleteUser(User user);

    ProcessResult saveStudent(Student student);

    ProcessResult deleteStudent(Student student);

    ProcessResult saveSubject(Subject subject);

    ProcessResult deleteSubject(Subject subject);

    ProcessResult saveTeacher(Teacher teacher);

    ProcessResult deleteTeacher(Teacher teacher);

    ProcessResult saveScore(Score score);

    ProcessResult deleteScore(Score score);

    ProcessResult saveTeacherAndSubject(TeacherAndSubject teacherAndSubject);

    ProcessResult deleteTeacherAndSubject(TeacherAndSubject teacherAndSubject);

    ProcessResult saveSchool(School school);

    ProcessResult deleteSchool(School school);
}
